package org.example;
import java.util.List;
public class CouponPromotion implements Promotion {
    private final String productCode;
    public CouponPromotion(String productCode) {
        this.productCode = productCode;
    }
    @Override
    public List<Product> apply(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return products;
        }
        for (Product product : products) {
            if (product == null || product.getCode() == null) {
                continue;
            }
            if (product.getCode().equals(productCode)) {
                double newPrice = product.getDiscountPrice() * 0.7;
                product.setDiscountPrice(newPrice);
            }
        }
        return products;
    }
}