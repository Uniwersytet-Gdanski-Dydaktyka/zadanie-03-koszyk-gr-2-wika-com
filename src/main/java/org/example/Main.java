package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addProduct(new Product("P1", "Laptop", 3500));
        cart.addProduct(new Product("P2", "Mysz", 100));
        cart.removeProduct("P2");

        List<Product> products = List.of(cart.getProducts().toArray(new Product[0]));
        List<Promotion> promotions = List.of(
                new PercentagePromotion(),
                new BuyTwoGetOnePromotion(),
                new CouponPromotion("P1"),
                new FreeMugPromotion()
        );

        PromotionEngine engine = new PromotionEngine(promotions);
        List<Product> finalCart = engine.applyAll(List.of((Product) products));
        for (Product p : finalCart) {
            if (p != null) {
                System.out.println(p.getName() + " " + p.getDiscountPrice());
            }
        }
        CartService service = new CartService();
        double total = service.calculateTotal((Cart) finalCart);
        System.out.println("Suma końcowa: " + total);
    }
}