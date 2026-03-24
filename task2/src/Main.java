import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int sum = sumRecursive(n);
        System.out.println((double) sum / n);
    }

    public static int sumRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        int num = sc.nextInt();
        return num + sumRecursive(n - 1);
    }
}