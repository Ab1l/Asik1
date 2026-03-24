import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        printDigits(n);
    }

    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
        } else {
            printDigits(n / 10);
            System.out.println(n % 10);
        }
    }
}