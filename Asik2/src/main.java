import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<BankAcc> list = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        // аккаунты
        list.add(new BankAcc("Abil", 1000));
        list.add(new BankAcc("Ahmed", 2000));
        list.add(new BankAcc("Sara", 1500));

        int c;

        do {
            System.out.println("\n1-Банк 2-Банкомат 3-Админ 4-Выход");
            c = sc.nextInt();
            sc.nextLine();

            if (c == 1) bank(list, stack, queue, sc);
            if (c == 2) atm(list, stack, sc);
            if (c == 3) admin(list, stack, queue);

        } while (c != 4);
    }

    // тут крч банк
    static void bank(LinkedList<BankAcc> list, Stack<String> stack, Queue<String> queue, Scanner sc) {

        System.out.println("1-Пополнить 2-Снять 3-Баланс");
        int c = sc.nextInt();
        sc.nextLine();

        System.out.print("Имя: ");
        String name = sc.nextLine();

        BankAcc acc = find(list, name);

        if (acc == null) {
            System.out.println("Аккаунт не найден");
            return;
        }

        if (c == 1) {
            System.out.print("Сумма: ");
            double x = sc.nextDouble();

            if (x > 0) {
                acc.balance += x;
                stack.push("Пополнение: " + name + " +" + x);
                queue.offer("Запрос на пополнение от: " + name);
                System.out.println("Готово");
            }
        }

        if (c == 2) {
            System.out.print("Сумма: ");
            double x = sc.nextDouble();

            if (x <= acc.balance) {
                acc.balance -= x;
                stack.push("Вывод: " + name + " -" + x);
                queue.offer("Запрос на вывод от: " + name);
                System.out.println("Все готово мабой");
            } else {
                System.out.println("Недостаточно мани, иди зарабатывай мани-мани");
            }
        }

        if (c == 3) {
            System.out.println("Баланс: " + acc.balance);
        }
    }

    // тут у нас банкоматт
    static void atm(LinkedList<BankAcc> list, Stack<String> stack, Scanner sc) {

        System.out.println("1-Снять 2-Баланс");
        int c = sc.nextInt();
        sc.nextLine();

        System.out.print("Имя: ");
        String name = sc.nextLine();

        BankAcc acc = find(list, name);

        if (acc == null) {
            System.out.println("Аккаунт не найден");
            return;
        }

        if (c == 1) {
            System.out.print("Сумма: ");
            double x = sc.nextDouble();

            if (x <= acc.balance) {
                acc.balance -= x;
                stack.push("Снятие у банкомата: " + name + " -" + x);
                System.out.println("Выдано");
            } else {
                System.out.println("Недостаточно мани, иди зарабатывай мани-мани");
            }
        }

        if (c == 2) {
            System.out.println("Баланс: " + acc.balance);
        }
    }

    // тут у нас админ панель
    static void admin(LinkedList<BankAcc> list, Stack<String> stack, Queue<String> queue) {

        System.out.println("\n=== АККАУНТЫ ===");
        for (BankAcc a : list) {
            System.out.println(a.name + " " + a.balance);
        }

        System.out.println("\nПоследняя операция:");
        if (!stack.isEmpty()) {
            System.out.println(stack.peek());
        }

        System.out.println("\nОчередь операций:");
        if (!queue.isEmpty()) {
            System.out.println(queue.poll()); // FIFO
        }
    }

    // тут у нас поиск
    static BankAcc find(LinkedList<BankAcc> list, String name) {
        for (BankAcc a : list) {
            if (a.name.equalsIgnoreCase(name)) return a;
        }
        return null;
    }
}