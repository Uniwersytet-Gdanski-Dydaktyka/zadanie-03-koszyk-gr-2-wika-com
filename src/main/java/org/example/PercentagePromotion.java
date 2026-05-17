package org.example;
import java.util.List;

public class PercentagePromotion implements Promotion {
    @Override
    public List<Product> apply(List<Product> products){
        if (products == null || products.isEmpty()) {
            return products;
        }
        ProductService service = new ProductService();
        double total = service.calculateTotal(products);
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
