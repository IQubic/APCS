import java.util.ArrayList;

public class Factor {
    public static void main(String args[]) {
        int arg = Integer.parseInt(args[0]);
        System.out.println(arg + " " + factor(arg));
    }

    public static ArrayList<Integer> factor(int n) throws IllegalArgumentException {
        ArrayList<Integer> factors = new ArrayList<>();
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            factors.add(1);
            return factors;
        }

        if (n % 2 == 0) {
            factors.add(2);
            factors.addAll(factor(n / 2));
            return factors;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                factors.add(i);
                factors.addAll(factor(n / i));
                return factors;
            }
        }
        factors.add(n);
        return factors;
    }
}
