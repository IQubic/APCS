import java.util.ArrayList;

public class Factor {
    public static void main(String args[]) {
        Long arg = Long.parseLong(args[0]);
        System.out.println(arg + " " + factor(arg));
    }

    public static ArrayList<Long> factor(long n) throws IllegalArgumentException {
        ArrayList<Long> factors = new ArrayList<>();
        long divisor = 1;
        if (n == 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            factors.add((long) 1);
            return factors;
        }

        // Base Case
        if (isPrime(n)) {
            factors.add(n);
            return factors;
        }

        // Recursive stuff
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisor = n / i;
                factors.add(i);
                break;
            }
        }
        factors.addAll(factor(divisor));
        return factors;
    }

    public static boolean isPrime(double n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
