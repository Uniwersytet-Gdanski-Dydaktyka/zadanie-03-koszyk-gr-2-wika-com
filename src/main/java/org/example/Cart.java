package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    public void  removeProduct(String code) {
        if (code == null || products.isEmpty()) {
            return;
        }
        products.removeIf(product ->
                product != null &&
                        code.equals(product.getCode()));
    }
}
