package org.example;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int priceCompare = Double.compare(o2.getDiscountPrice(), o1.getDiscountPrice());
        if (priceCompare == 0) {
            if (o1.getName() == null || o2.getName() == null) {
                return 0;
            }
            return o1.getName().compareTo(o2.getName());
        }
        return priceCompare;
    }
}
