package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("P1", "Laptop", 3500),
                new Product("P2", "Mysz", 100),
                new Product("P3", "Klawiatura", 250)
        ));

        List<Promotion> promotions = List.of(
                new PercentagePromotion(),
                new BuyTwoGetOnePromotion(),
                new CouponPromotion("P1"),
                new FreeMugPromotion()
        );

        PromotionEngine engine = new PromotionEngine(promotions);
        List<Product> finalCart = engine.applyAll(products);
        for (Product p : finalCart) {
            if (p != null) {
                System.out.println(p.getName() + " " + p.getDiscountPrice());
            }
        }
        ProductService service = new ProductService();
        double total = service.calculateTotal(finalCart);
        System.out.println("Suma końcowa: " + total);
    }
}