package org.example;
import java.util.List;
public class CouponPromotion implements Promotion {
    private final String productCode; // nie mozna zmienic kodu
    public CouponPromotion(String productCode) {
        this.productCode = productCode;
    }
    @Override
    public List<Product> apply(Cart cart) {
        if (cart == null || cart.getProducts() == null || cart.getProducts().size() < 3) {
            return cart.getProducts();
        }
        List<Product> products = cart.getProducts();
        Product min = products.get(0);
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