import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Product> products = new ArrayList<>();

    public Product addProduct(String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
        System.out.println("Товар \"" + name + "\" успешно добавлен.");
        return product;
    }

    public boolean promptForNextProduct(String response) {
        return !response.equalsIgnoreCase("Завершить");
    }

    public void displayProductsAndTotal(int countPersons) {
        double total = 0;
        System.out.println("Все добавленные товары:");
        for (Product product : products) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println(String.format("Общая сумма: %.2f ", total) + Product.sklonenie(total));
        double totalPerPerson = total / countPersons;
        System.out.println("Каждый человек должен заплатить: " + String.format("%.2f", totalPerPerson) + " " + Product.sklonenie(totalPerPerson) + ".");
    }
}
