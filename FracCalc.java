import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        //Parse one line of input
        if (input.equals("test") {
            runTests();
        } else {
            System.out.println(produceAnswer(input));
        }
    }

    public static String produceAnswer(String input) {
        String[] expression = input.split();
        return expression[2];
    }
    
    //Runs all tests and prints the results of the tests
    public static void runTests() {

    }
    
    //Runs a single test and sees if it passed
    public static boolean testPassed(String input, String expectedOutput) {

    }

}
