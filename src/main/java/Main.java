import java.util.Scanner;
import java.util.Locale;

public class Main {
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        int countPersons = getInt("Некорректное значение. Введите целое число больше 1:");

        while (countPersons <= 1) {
            System.out.println("Некорректное значение: Введите количество человек больше 1!");
            countPersons = getInt("Некорректное значение. Введите целое число больше 1:");
        }
        System.out.println(String.format("Вы ввели: %d человек", countPersons));

        Calculator calculator = new Calculator();
        do {
            System.out.println("Введите название товара:");
            String name = getString();
            System.out.println("Введите стоимость товара в формате рубли.копейки (например, 10.45):");
            double price = getDouble("Некорректное значение: Введите число в формате 10.45");

            calculator.addProduct(name, price);

            System.out.println("Добавить еще один товар? (Введите 'завершить' для завершения)");
        } while (calculator.promptForNextProduct(getString()));

        calculator.displayProductsAndTotal(countPersons);

        scanner.close();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static double getDouble(String message) {
        while (!scanner.hasNextDouble()) {
            System.out.println(message);
            scanner.nextLine();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public static int getInt(String message) {
        while (!scanner.hasNextInt() ) {
            System.out.println(message);
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
