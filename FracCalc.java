import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Print out a greeting
        System.out.println("Welcome to FracCalc!");
        System.out.println("Enter an equation or \"quit\" to quit");

        // Parse input
        String input = console.nextLine().toLowerCase();

        while (!input.equals("quit")) {
            if (input.equals("test")) {
                runTests();
            } else {
                System.out.println(produceAnswer(input));
            }
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

        int[] output = new int[2];
        switch (expression[1]) {
            case '+': output = addFrac(frac1, frac2);
                      break;
            case '-': output = subFrac(frac1, frac2);
                      break;
            case '*': output = mulFrac(frac1, frac2);
                      break;
            case '/': output = divFrac(frac1, frac2);
                      break;
        }

        return fracToString(output);
    }

    // All the Mathematical Operations take int[] of Imporper Fractions in the form:
    // {Numerator, Denominator}

    public static int[] addFrac(int[] frac1, int[] frac2) {
        //TODO Implement this
    }

    public static int[] subFrac(int[] frac1, int[] frac2) {
        //TODO Implement this
    }

    public static int[] mulFrac(int[] frac1, int[] frac2) {
        //TODO Implement this
    }

    public static int[] divFrac(int[] frac1, int[] frac2) {
        return mulFrac(frac1, {frac2[1], frac2[0]});
    }

    public static String fracToString(int[] frac) {
        return frac[0] + "_" + frac[1] + "/" + frac[2];
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
        return intFrac[i];
    }

    // Runs all tests and prints the results of the tests
    public static void runTests() {
        // Each pair of elements in this array goes together:
        // tests[i] = [test case, expected output]
        // TODO ADD MORE TESTS
        // TODO UPDATE THE RESULTS OF THE TESTS
        String[][] tests = {{"1/2 + 1/2", "Whole: 0, Numerator: 1, Denominator: 2"},
                            {"1_2/3 * 1_3/4" , "Whole: 1, Numerator: 3, Denominator: 4"},
                            {"2 / 3", "Whole: 3, Numerator: 0, Denominator: 0"},
                            {"1 - 1_2/3", "Whole: 1, Numerator: 2, Denominator: 3"},
                            {"-3 * 4/2", "Whole: 0, Numerator: 4, Denominator: 2"},
                            {"1_1/2 - -4", "Whole: -4, Numerator: 0, Denominator: 0"},
                            {"1 + 1/-2", "Whole: 0, Numerator: 1, Denominator: -2"}};

        // Let's run the tests
        int numOfTests = tests.length;
        int numOfTestsPassed = 0;
        for (String[] currentTest : tests) {
            String testCase = currentTest[0];
            String expectedResult = currentTest[1];
            String actualResult = produceAnswer(testCase);
            if ( actualResult.equals(expectedResult)) {
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
