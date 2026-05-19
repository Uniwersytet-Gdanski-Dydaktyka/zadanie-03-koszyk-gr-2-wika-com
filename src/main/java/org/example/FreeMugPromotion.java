package org.example;
import java.util.List;

public class FreeMugPromotion implements Promotion {
    @Override
    public List<Product> apply(Cart cart){
        if (cart == null || cart.getProducts() == null || cart.getProducts().size() < 3) {
            return null;
        }
        CartService service = new CartService();
        double total = service.calculateTotal(cart);
        if (total > 200){
            Product mug = new Product("MUG", "Kubek", 0);
            cart.getProducts().add(mug);
        }
        return cart.getProducts();
    }
}
