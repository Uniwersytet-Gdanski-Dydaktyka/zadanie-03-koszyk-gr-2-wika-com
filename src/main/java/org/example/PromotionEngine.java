package org.example;
import java.util.List;
import java.util.ArrayList;

public class PromotionEngine {
    private final List<Promotion> promotions;

    public PromotionEngine(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Product> applyAll(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return products;
        }
        List<Product> result = new ArrayList<>(products);
        for (Promotion promotion : promotions) {
            if (promotion != null) {
                result = promotion.apply(result);
            }
        }
        return result;
    }
}

