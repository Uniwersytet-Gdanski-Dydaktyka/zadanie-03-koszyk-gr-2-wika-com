package org.example;
import java.util.List;

public class FreeMugPromotion implements Promotion {
    @Override
    public List<Product> apply(List<Product> products){
        if (products == null) {
            return null;
        }
        ProductService service = new ProductService();
        double total = service.calculateTotal(products);
        if (total > 200){
            Product mug = new Product("MUG", "Kubek", 0);
            products.add(mug);
        }
        return products;
    }
}
