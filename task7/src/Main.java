import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        reverseNumbers(n);
    }

    public static void reverseNumbers(int n) {
        if (n == 0) {
            return;
        }
        int num = sc.nextInt();
        reverseNumbers(n - 1);
        System.out.print(num + " ");
    }
}