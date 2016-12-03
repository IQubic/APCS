import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Print out a greeting
        System.out.println("Welcome to FracCalc!");
        System.out.println("Enter an equation or \"quit\" to quit");

        System.out.print("> ");

        // Parse input
        String input = console.nextLine().toLowerCase();

        while (!input.equals("quit")) {
            if (input.equals("test")) {
                runTests();
            } else {
                System.out.println(produceAnswer(input));
            }
            System.out.print("> ");
            input = console.nextLine().toLowerCase();
        }

        // Print an exit message
        System.out.println("Goodbye!");
    }

    // A call to produceAnswer gives the result of a given input
    public static String produceAnswer(String input) {
        ArrayList<int[]> fracs = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();

        // Try to parse the equation and return an error message if needed
        try {
            parseEqn(input, fracs, operators);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        // Evaluate the equation
        evaluateEqn(fracs, operators);

        // Reduce the fraction and turn it into a String
        return reduceFracToString(fracs.get(1));
    }

    //TODO Comment this method
    public static void parseEqn(String input, ArrayList<int[]> fracs, ArrayList<String> operators) throws IllegalArgumentException {
        String[] eqn = input.split(" ");

        if (eqn.length == 0) {
            throw new IllegalArgumentException("No Input Given");
        }

        for (int i = 0; i < eqn.length; i++) {
            String nextToken = eqn[0];
            if (i % 2 == 0) {
                try {
                    int[] parsedFrac = parseFrac(nextToken);
                    int[] improperFrac = toImproperFrac(parsedFrac);
                    fracs.add(improperFrac);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Parse error on input: Invalid Fraction \"" + nextToken + "\"");
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Parse error on input: Divide by Zero \"" + nextToken + "\"");
                }
            } else {
                if (isAnOperator(nextToken)) {
                    operators.add(nextToken);
                } else {
                    throw new IllegalArgumentException("Parse error on input: Illegal Operator \"" + nextToken + "\"");
                }
            }
        }
    }

    // TODO Implement this method
    public static void evaluateEqn(ArrayList<int[]> fracs, ArrayList<String> operators) {

    }


    // All the Mathematical Operations take two int[] of Imporper Fractions in the form:
    // {Numerator, Denominator}
    // And return an int[] of the same form

    public static int[] addFrac(int[] frac1, int[] frac2) {
        return new int[] {frac1[0] * frac2[1] + frac2[0] * frac1[1],
            frac1[1] * frac2[1]};
    }

    // Subtracting is the same as adding a negative
    public static int[] subFrac(int[] frac1, int[] frac2) {
        return addFrac(frac1, new int[] {-frac2[0], frac2[1]});
    }

    public static int[] mulFrac(int[] frac1, int[] frac2) {
        return new int[] {frac1[0] * frac2[0],
            frac1[1] * frac2[1]};
    }

    // Division is the same as multiplying by the reciprical
    public static int[] divFrac(int[] frac1, int[] frac2) {
        return mulFrac(frac1, new int[] {frac2[1], frac2[0]});
    }

    // This method will recieve an int[] of length 2
    // It will return a reduced fraction of the form "a_b/c"
    public static String reduceFracToString(int[] inputFrac) {
        // FinalFrac is the reduced fraction
        int[] finalFrac = new int[3];

        // The isNegative flag tracks if the input is negative
        // Working with a positive fraction makes
        // Reducing and converting to a Mixed Number a lot simpler
        boolean isNegative = false;
        if (inputFrac[0] < 0) {
            inputFrac[0] = -inputFrac[0];
            isNegative = true;
        }

        // Turn into an mixed number
        finalFrac[0] = inputFrac[0] / inputFrac[1];
        finalFrac[1] = inputFrac[0] % inputFrac[1];
        finalFrac[2] = inputFrac[1];

        // Reduce the fractional part
        int gcd = gcd(finalFrac[1], finalFrac[2]);
        finalFrac[1] /= gcd;
        finalFrac[2] /= gcd;

        // Convert to a string
        // Whole Number
        if (finalFrac[1] == 0) {
            if (isNegative) {
                finalFrac[0] = -finalFrac[0];
            }
            return String.valueOf(finalFrac[0]);
        // Just a fration
        } else if (finalFrac[0] == 0){
            if (isNegative) {
                finalFrac[1] = -finalFrac[1];
            }
            return finalFrac[1] + "/" + finalFrac[2];
        } else {
            if (isNegative) {
                finalFrac[0] = -finalFrac[0];
            }
            return  finalFrac[0] + "_" + finalFrac[1] + "/" + finalFrac[2];
        }
    }

    // Euclid's algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int newB = a % b;
            a = b;
            b = newB;
        }

        return a;
    }

    // This method returns an int[] of length 2
    public static int[] toImproperFrac(int[] frac) throws ArithmeticException {
        int[] improperFrac;
        if (frac.length == 1) {
            improperFrac = new int[] {frac[0], 1};
        } else if (frac.length == 2) {
            improperFrac = frac;
        } else {
            improperFrac = new int[] {frac[0] * frac[2] + frac[1], frac[2]};
        }
        // Divide by zero error
        if (improperFrac[1] == 0) {
            throw new ArithmeticException();
        } else {
            return improperFrac;
        }
    }

    // parseFrac takes a String and returns an int[] repersenting the fraction
    public static int[] parseFrac(String frac) throws NumberFormatException {
        // Split the fraction its parts
        String[] stringFrac = frac.split("[_/]");

        // Parse the Strings into ints
        int[] intFrac = new int[stringFrac.length];
        for (int i = 0; i < stringFrac.length; i++) {
            intFrac[i] = Integer.parseInt(stringFrac[i]);
        }
        return intFrac;
    }

    public static boolean isAnOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    // Runs all tests and prints the results of the tests
    public static void runTests() {
        // Each pair of elements in this array goes together:
        // tests[i] = [test case, expected output]
        String[][] tests = {{"1/2 + 1/2", "1"},
                            {"39/130 + 0", "3/10"},
                            {"130/39 + 0", "3_1/3"},
                            {"-3/4 + -3/4", "-1_1/2"},
                            {"1_2/3 * 1_3/4", "2_11/12"},
                            {"2 / 3", "2/3"},
                            {"2 * 4", "8"},
                            {"3 + 2", "5"},
                            {"5 - 2", "3"},
                            {"1 - 1_2/3", "-2/3"},
                            {"-3 * 4/2", "-6"},
                            {"1_1/2 - -4", "5_1/2"},
                            {"-4 - 1_1/2", "-5_1/2"},
                            {"1 + -1/2", "1/2"},
                            {"-1/2 + 1", "1/2"},
                            {"1/2 / 1/2", "1"},
                            {"1/2 * 1", "1/2"},
                            {"1 * 1/2", "1/2"},
                            {"1/2 / 1", "1/2"}};

        // Let's run the tests
        int numOfTests = tests.length;
        int numOfTestsPassed = 0;
        for (String[] currentTest : tests) {
            String testCase = currentTest[0];
            String expectedResult = currentTest[1];
            String actualResult = produceAnswer(testCase);
            if (actualResult.equals(expectedResult)) {
                // Test passed
                numOfTestsPassed++;
            } else {
                // Test failed
                System.out.println("\"" + testCase + "\" returned: \"" + actualResult + "\". Expected result was: \"" + expectedResult + "\"");
            }
        }
        // After all tests are run
        System.out.println(numOfTestsPassed + " out of " + numOfTests + " tests passed");
    }
}
