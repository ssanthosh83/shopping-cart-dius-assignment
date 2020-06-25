package org.santhosh.computerstore;

import org.santhosh.computerstore.models.Product;
import org.santhosh.computerstore.models.Sku;
import org.santhosh.computerstore.offers.Offer;

import java.util.ArrayList;
import java.util.List;

/**
 *   Main class for Items checkout in the Shopping cart Application
 */
public class Checkout {

    private List<Offer> offers;
    private List<Product> productList;

    public Checkout() {
        productList = new ArrayList<>();
    }

    public Checkout(List<Offer> offers) {
        this.offers = offers;
        productList = new ArrayList<>();
    }

    /**
     * Method to scan the products with the SKU code
     * @param sku
     */
    public void scan(Sku sku){
        productList.add(new Product(sku.toString(), sku.getDescription(), sku.getPrice()));
    }

    public List<Product> getProductList() {
        return productList;
    }

    /**
     *  Method to calculate the final price after applying all offers.
     * @return TotalPrice
     */
    public Double getTotalPrice() {

        Double total = 0.0;

        if(offers != null) {
            offers.stream().forEach(offer -> {
                productList = offer.modifyProducts(productList);
            });
        }
        for(Product product: productList){
            total += product.getPrice() - product.getDiscountedPrice();
        }
        return total;
    }
}
