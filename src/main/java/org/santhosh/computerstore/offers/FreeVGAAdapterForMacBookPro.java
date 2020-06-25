package org.santhosh.computerstore.offers;

import org.santhosh.computerstore.models.Product;
import org.santhosh.computerstore.models.Sku;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Algorithm for the Offer : Free VGA Adapter for buying MacBook Pro
 */
public class FreeVGAAdapterForMacBookPro implements Offer {
    @Override
    public List<Product> modifyProducts(List<Product> products) {

        AtomicInteger numberOfMacBookPros = new AtomicInteger(0);
        AtomicInteger numberOfVGAAdapter = new AtomicInteger(0);
        products.stream().forEach(product -> {
            if(product.getSku().equals(Sku.MBP.toString()))
                numberOfMacBookPros.getAndIncrement();
            if(product.getSku().equals(Sku.VGA.toString()))
                numberOfVGAAdapter.getAndIncrement();
        });

        while(numberOfMacBookPros.get()>0){
            if(numberOfVGAAdapter.get() > 0){
                products.stream().forEach(product -> {
                    if(product.getSku().equals(Sku.VGA.toString())) {
                        product.setDiscountedPrice(product.getPrice());
                        numberOfVGAAdapter.getAndDecrement();
                    }
                });
            } else {
                Product newProduct = new Product(Sku.VGA);
                newProduct.setDiscountedPrice(Sku.VGA.getPrice());
                products.add(newProduct);
            }
            numberOfMacBookPros.decrementAndGet();
        }
        return products;
    }
}
