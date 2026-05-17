package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProductService {
    public Product findCheapest(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return null;
        }
        Product cheapest = null;
        for (Product product : products) {
            if (product == null) {
                continue;
            }
            if (cheapest == null || product.getDiscountPrice() < cheapest.getDiscountPrice()) {
                cheapest = product;
            }
        }
        return cheapest;
    }

    public List<Product> findNCheapest(List<Product> products, int number) {
        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }
// tworzymy kopię listy, aby nie zmieniać oryginalnej kolejności w koszyku
        List<Product> copy = new ArrayList<>();
        for (Product p : products) {
            if (p != null) {
                copy.add(p);
            }
        }

        copy.sort(Comparator.comparingDouble(Product::getDiscountPrice));

        if (number > copy.size()) {
            number = copy.size();
        }
// podlista od 0 do 'number'
        return copy.subList(0, number);
    }

    public void sort(List<Product> products, Comparator<Product> comparator) {
        if (products == null || products.isEmpty() || comparator == null) {
            return;
        }
        products.sort(comparator);
    }

//    public void sort(Product[] products, Comparator<Product> comparator) {
//        if (products == null || products.length == 0) {
//            return;
//        }
//        Arrays.sort(products, comparator);
//    }

    public double calculateTotal(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Product product : products) {
            if (product == null) {
                continue;
            }
            sum += product.getDiscountPrice();
        }
        return sum;
    }
}
