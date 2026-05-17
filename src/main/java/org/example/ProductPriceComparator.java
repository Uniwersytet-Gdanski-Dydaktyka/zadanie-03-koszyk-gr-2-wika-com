package org.example;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getDiscountPrice(), o2.getDiscountPrice());
    }
}
