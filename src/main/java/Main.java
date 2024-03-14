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
            String name = getString("Введите название товара:");
            double price = getDouble("Введите стоимость товара в формате рубли.копейки (например, 10.45):");

            calculator.addProduct(name, price);
            scanner.nextLine();

        } while (calculator.promptForNextProduct(getString("Добавить еще один товар? (Введите 'завершить' для завершения) или любой символ для добавления товаров")));

        calculator.displayProductsAndTotal(countPersons);

        scanner.close();
    }

    public static String getString(String message) {
        String input;
        while (true) {
            System.out.println(message);
            input = scanner.nextLine();
            if (input.isBlank()) {
                System.out.println("Некорректное значение: строка пуста или содержит только пробелы. Пожалуйста, введите что-нибудь еще:");
            } else if (input.matches("\\d+")) {
                System.out.println("Некорректное значение: не должно состоять только из цифр");
            } else {
                break;
            }
            scanner.nextLine();
        }
        return input;
    }

    public static double getDouble(String message) {
        double value;
        while (true) {
            System.out.println(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Некорректное значение: число не должно быть отрицательным.");
                }
            } else {
                System.out.println("Некорректное значение: введенное значение не является числом.");
            }
            scanner.nextLine();
        }
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
