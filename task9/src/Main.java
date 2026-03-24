import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        System.out.println(countChars(s));
    }

    public static int countChars(String s) {
        if (s.equals("")) {
            return 0;
        }
        return 1 + countChars(s.substring(1));
    }
}