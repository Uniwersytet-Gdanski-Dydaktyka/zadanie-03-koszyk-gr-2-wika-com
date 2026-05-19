package org.example;
import java.util.List;

public class PercentagePromotion implements Promotion {
    @Override
    public List<Product> apply(Cart cart){
        if (cart == null || cart.getProducts() == null || cart.getProducts().isEmpty()) {
            return cart.getProducts();
        }
        CartService service = new CartService();
        List<Product> products = cart.getProducts();
        double total = service.calculateTotal(cart);
        if (total > 300){
            for (Product product : products){
                if (product != null) {
                    double newPrice = product.getDiscountPrice() * 0.95;
                    product.setDiscountPrice(newPrice);
                }
            }
            return products;
        }
        return products;
    }
}
