import java.util.Locale;
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;

        this.price = price;
    }
    @Override
    public String toString() {
        return name + " - " + String.format(Locale.US,"%.2f", price) + sklonenie(price);
    }

    public static String sklonenie(double amount) {
        int rubles = (int) amount;
        int lastDigit = rubles % 10;
        int lastTwoDigits = rubles % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return " рублей";
        } else if (lastDigit == 1) {
            return " рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return " рубля";
        } else {
            return " рублей";
        }
    }

    public double getPrice() {
        return price;
    }
}
