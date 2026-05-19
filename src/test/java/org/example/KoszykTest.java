package org.example;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KoszykTest {
    @Test
    void findCheapestProduct() {Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Laptop", 3500));
        cart.addProduct(new Product("P2", "Myszka", 100));
        cart.addProduct(new Product("P3", "Stardew Valley", 250));
        CartService service = new CartService();
        Product result = service.findCheapest(cart);
        assertEquals("P2", result.getCode());
    }

    @Test
    void calculateTotal() {
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Laptop", 100));
        cart.addProduct(new Product("P2", "SuperMario Bros", 200));
        CartService service = new CartService();
        double total = service.calculateTotal((Cart) cart.getProducts());
        assertEquals(300, total);
    }

    @Test
    void percentagePromotion() {
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Laptop", 400));
        Promotion promo = new PercentagePromotion();
        List<Product> result = promo.apply(cart);
        assertEquals(380, result.get(0).getDiscountPrice(), 0.01);
    }

    @Test
    void applyCoupon() {
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Laptop", 1000));
        Promotion promo = new CouponPromotion("P1");
        List<Product> result = promo.apply(cart);
        assertEquals(700, result.get(0).getDiscountPrice(), 0.01);
    }

    @Test
    void cheapestFree() {
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Huśtawka", 100));
        cart.addProduct(new Product("P2", "Winyle", 200));
        cart.addProduct(new Product("P3", "Lampka", 50));
        Promotion promo = new BuyTwoGetOnePromotion();
        List<Product> result = promo.apply(cart);
        Product cheapest = result.get(result.size() - 1);
        assertEquals(0, cheapest.getDiscountPrice(), 0.01);
    }

    @Test
    void freeMugPromotionTest() {
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Buty", 250));
        Promotion promo = new FreeMugPromotion();
        List<Product> result = promo.apply(cart);
        assertEquals(2, result.size());
        assertEquals("MUG", result.get(1).getCode());
        assertEquals(0, result.get(1).getDiscountPrice(), 0.01);
    }
}
