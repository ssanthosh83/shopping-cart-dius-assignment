package org.santhosh.computerstore.offers;

import org.santhosh.computerstore.models.Product;
import org.santhosh.computerstore.models.Sku;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Algorithm for the Offer : IPAD Bulk Discount for buying more than or equal to 4
 */
public class SuperIPadBulkDiscountFor4 implements Offer {
    @Override
    public List<Product> modifyProducts(List<Product> products) {

        AtomicInteger numberOfIpads = new AtomicInteger(0);

        products.stream().forEach(product -> {
            if(product.getSku().equals(Sku.IPD.toString()))
                numberOfIpads.getAndIncrement();
        });

        products.stream().forEach(product -> {
            if(numberOfIpads.get() >= 4 && product.getSku().equals(Sku.IPD.toString())){
                product.setDiscountedPrice(50.00);
             }
        });

        return  products;
    }
}
