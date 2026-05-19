package org.example;

import java.util.List;

public class BuyTwoGetOnePromotion implements Promotion{
    @Override
    public List<Product> apply(Cart cart){
        if (cart == null || cart.getProducts() == null || cart.getProducts().size() < 3) {
            return cart.getProducts();
        }
        List<Product> products = cart.getProducts();
        Product min = products.get(0);
        for (Product product : products) {
            if (product == null) {
                continue;
            }
            if (product.getDiscountPrice() < min.getDiscountPrice()) {
                min = product;
            }
        }
        min.setDiscountPrice(0);
        return cart.getProducts();
    }
}