import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        if (isPrime(n, 2)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
    }

    public static boolean isPrime(int n, int divisor) {
        if (n < 2) {
            return false;
        }
        if (divisor == n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrime(n, divisor + 1);
    }
}