package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CartService {
    public Product findCheapest(Cart cart) {
        if (cart == null || cart.getProducts().isEmpty()) {
            return null;
        }
        Product cheapest = null;
        for (Product product : cart.getProducts()) {
            if (product == null) continue;

            if (cheapest == null || product.getDiscountPrice() < cheapest.getDiscountPrice()) {
                cheapest = product;
            }
        }
        return cheapest;
    }

    public List<Product> findNCheapest(Cart cart, int number) {
        if (cart == null || cart.getProducts().isEmpty()) {
            return new ArrayList<>();
        }
// tworzymy kopię listy, aby nie zmieniać oryginalnej kolejności w koszyku
        List<Product> copy = new ArrayList<>();
        for (Product p : cart.getProducts()) {
            if (p != null) {
                copy.add(p);
            }
        }
        copy.sort(new ProductPriceComparator().reversed());
        if (number > copy.size()) {
            number = copy.size();
        }
// podlista od 0 do number
        return copy.subList(0, number);
    }

    public void sort(Cart cart, Comparator<Product> comparator) {
        if (cart == null || cart.getProducts().isEmpty() || comparator == null) {
            return;
        }
        cart.getProducts().sort(comparator);
    }

    public double calculateTotal(Cart cart) {
        if (cart == null || cart.getProducts().isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Product product : cart.getProducts()) {
            if (product != null) {
                sum += product.getDiscountPrice();
            }
        }
        return sum;
    }
}
