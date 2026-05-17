package org.example;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KoszykTest {
    @Test
    void findCheapestProduct() {
        ProductService service = new ProductService();
        List<Product> products = new ArrayList<>(List.of(
                new Product("P1", "Laptop", 3500),
                new Product("P2", "Myszka", 100),
                new Product("P3", "Stardew Valley", 250)
        ));
        Product result = service.findCheapest(products);
        assertEquals("P2", result.getCode());
    }

    @Test
    void calculateTotal() {
        ProductService service = new ProductService();
        List<Product> products = new ArrayList<>(List.of(
                new Product("P1", "Laptop", 100),
                new Product("P2", "SuperMario Bros", 200)
        ));
        double total = service.calculateTotal(products);
        assertEquals(300, total);
    }

    @Test
    void percentagePromotion() {
        List<Product> products = new ArrayList<>(List.of(
                new Product("P1", "Laptop", 400)
        ));
        Promotion promo = new PercentagePromotion();
        List<Product> result = promo.apply(products);
        assertEquals(380, result.get(0).getDiscountPrice(), 0.01);
    }

    @Test
    void applyCoupon() {
        List<Product> products = new ArrayList<>(List.of(
                new Product("P1", "Laptop", 1000)
        ));
        Promotion promo = new CouponPromotion("P1");
        List<Product> result = promo.apply(products);
        assertEquals(700, result.get(0).getDiscountPrice(), 0.01);
    }

    @Test
    void cheapestFree() {
        List<Product> products = new ArrayList<>(List.of(
                new Product("P1", "A", 100),
                new Product("P2", "B", 200),
                new Product("P3", "C", 50)
        ));
        Promotion promo = new BuyTwoGetOnePromotion();
        List<Product> result = promo.apply(products);
        Product cheapest = result.get(result.size() - 1);
        assertEquals(0, cheapest.getDiscountPrice(), 0.01);
    }

    @Test
    void freeMugPromotionTest() {
        List<Product> products = new ArrayList<>(List.of(
                new Product("P1", "Buty", 250) // Suma > 200
        ));
        Promotion promo = new FreeMugPromotion();
        List<Product> result = promo.apply(products);
        assertEquals(2, result.size());
        assertEquals("MUG", result.get(1).getCode());
        assertEquals(0, result.get(1).getDiscountPrice(), 0.01);
    }
}
