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
        String[] expression = input.split(" ");

        // Turn a String like 1_2/3 into an int[], then into an improper fraction for easier calculations
        // toImproperFrac returns an int[] of length 2
        int[] frac1 = toImproperFrac(parseFrac(expression[0]));
        int[] frac2 = toImproperFrac(parseFrac(expression[2]));

        // Create a new array for storing the output, and call the appropriate
        // mathematical method
        int[] output = new int[2];
        switch (expression[1]) {
            case "+": output = addFrac(frac1, frac2);
                      break;
            case "-": output = subFrac(frac1, frac2);
                      break;
            case "*": output = mulFrac(frac1, frac2);
                      break;
            case "/": output = divFrac(frac1, frac2);
                      break;
        }

        // Reduce the fraction and turn it into a String
        return reduceFracToString(output);
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

        // First I create a mixed number
        // At this point the fractional part still might not be reduced
        finalFrac[0] = inputFrac[1] / inputFrac[2];
        finalFrac[1] = inputFrac[1] %  inputFrac[2];
        finalFrac[2] = inputFrac[2];

        return  finalFrac[0] + "_" + finalFrac[1] + "/" + finalFrac[2];
    }

    // This method returns an int[] of length 2
    public static int[] toImproperFrac(int[] frac) {
        if (frac.length == 1) {
            return new int[] {frac[0], 1};
        } else if (frac.length == 2) {
            return frac;
        } else {
            return new int[] {frac[0] * frac[2] + frac[1], frac[2]};
        }
    }

    // parseFraction takes a String and returns an int[] repersenting the fraction
    public static int[] parseFrac(String frac) {
        // Split the fraction its parts
        String[] stringFrac = frac.split("[_/]");

        // Parse the Strings into ints
        int[] intFrac = new int[stringFrac.length];
        for (int i = 0; i < stringFrac.length; i++) {
            intFrac[i] = Integer.parseInt(stringFrac[i]);
        }
        return intFrac;
    }

    // Runs all tests and prints the results of the tests
    public static void runTests() {
        // Each pair of elements in this array goes together:
        // tests[i] = [test case, expected output]
        String[][] tests = {{"1/2 + 1/2", "4/4"},
                            {"1_2/3 * 1_3/4", "35/12"},
                            {"2 / 3", "2/3"},
                            {"2 * 4", "8/1"},
                            {"3 + 2", "5/1"},
                            {"5 - 2", "3/1"},
                            {"1 - 1_2/3", "-2/3"},
                            {"-3 * 4/2", "-12/2"},
                            {"1_1/2 - -4", "11/2"},
                            {"-4 - 1_1/2", "-11/2"},
                            {"1 + -1/2", "1/2"},
                            {"-1/2 + 1", "1/2"},
                            {"1/2 / 1/2", "2/2"},
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
                System.out.println("\"" + testCase + "\" returned: " + actualResult + ". Expected result was: \"" + expectedResult + "\"");
            }
        }
        // After all tests are run
        System.out.println(numOfTestsPassed + " out of " + numOfTests + " tests passed");
    }
}
