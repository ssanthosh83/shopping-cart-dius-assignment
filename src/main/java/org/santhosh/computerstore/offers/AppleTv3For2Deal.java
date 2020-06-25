package org.santhosh.computerstore.offers;

import org.santhosh.computerstore.models.Product;
import org.santhosh.computerstore.models.Sku;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *   Algorithm for the Offer : Buy 3 Apple TVs for the price of 2
 */
public class AppleTv3For2Deal implements Offer {
    @Override
    public List<Product> modifyProducts(List<Product> products) {
        AtomicInteger appleTvCount = new AtomicInteger(0);

        products.stream().forEach(product -> {
            if(product.getSku().equals(Sku.ATV.toString())){
                appleTvCount.getAndIncrement();
                if(appleTvCount.get() == 3){
                    appleTvCount.set(0); // Reinitialize the produce price with discounted Price
                    product.setDiscountedPrice(product.getPrice());
                }
            }
        });
        return products;
    }
}
