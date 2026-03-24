import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        if (onlyDigits(s, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean onlyDigits(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }
        return onlyDigits(s, index + 1);
    }
}