package ch.heigvd.pdl.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private static int idCounter = 0;
    private final int id;

    public static void resetIdCounter() {
        idCounter = 0;
    }

    public Order() {
        this.id = idCounter++;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
