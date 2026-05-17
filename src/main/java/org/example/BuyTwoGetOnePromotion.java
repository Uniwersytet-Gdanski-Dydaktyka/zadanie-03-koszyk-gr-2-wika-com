package org.example;

import java.util.List;

public class BuyTwoGetOnePromotion implements Promotion{
    @Override
    public List<Product> apply(List<Product> products){
        if (products == null || products.size() < 3) {
            return products;
        }
        Product min= products.getFirst();
        for (Product product : products){
            if(product.getDiscountPrice()<min.getDiscountPrice()){
                min=product;
            }
        }
        min.setDiscountPrice(0);
        return products;
    }
}