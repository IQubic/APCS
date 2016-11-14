import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //Print out a greeting
        System.out.println("Welcome to FracCalc!");
        System.out.println("Enter an equation or \"quit\" to quit");

        //Parse one line of input
        String input = console.nextLine();
        if (input.equals("test")) {
            runTests();
        } else {
            System.out.println(produceAnswer(input));
        }
    }

    public static String produceAnswer(String input) {
        String[] expression = input.split(" ");
        return expression[2];
    }

    //Runs all tests and prints the results of the tests
    public static void runTests() {
        //Each pair of elements in this array goes together
        String[][] tests = {{"1/2 + 1/2", "1/2"},
                            {"1_2/3 * 1_3/4" , "1_3/4"},
                            {"2 / 3", "3"},
                            {"1 - 1_2/3", "1_2/3"},
                            {"-3 * 4/2", "4/2"},
                            {"1_1/2 - -4", "-4"}};

        //Let's run the tests
        int numOfTests = tests.length;
        int numOfTestsPassed = 0;
        for (String[] currentTest : tests) {
            String testCase = currentTest[0];
            String expectedResult = currentTest[1];
            String actualResult = produceAnswer(testCase);
            if ( actualResult.equals(expectedResult)) {
                //Test passed
                numOfTestsPassed++;
            } else {
                //Test failed
                System.out.println(testCase + " returned: " + actualResult + ". Expected result was: " + expectedResult);
            }
        }
        //After all tests are run
        System.out.println(numOfTestsPassed + " out of " + numOfTests + " tests passed");
    }
}
