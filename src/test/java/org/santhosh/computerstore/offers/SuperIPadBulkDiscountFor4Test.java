package org.santhosh.computerstore.offers;

import org.junit.jupiter.api.Test;
import org.santhosh.computerstore.models.Product;
import org.santhosh.computerstore.models.Sku;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class SuperIPadBulkDiscountFor4Test {

    Offer offer;
    Product product;
    List<Product> products;
    List<Product> modifiedProducts;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        offer = new SuperIPadBulkDiscountFor4();
        product = new Product(Sku.IPD);
        products = new ArrayList<>();
        modifiedProducts = new ArrayList<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        offer = null;
        product = null;
        products = null;
        modifiedProducts = null;
    }


    @Test
    public void testWithNoOffers(){
        products.add(product);
        modifiedProducts = offer.modifyProducts(products);
        assertThat(modifiedProducts, hasItem(product));
    }

    @Test
    public void testWithOffers(){
        products.add(new Product(Sku.IPD));
        products.add(new Product(Sku.IPD));
        products.add(new Product(Sku.IPD));
        products.add(new Product(Sku.IPD));
        modifiedProducts = offer.modifyProducts(products);
        product.setDiscountedPrice(50.00);
        assertThat(modifiedProducts, hasItem(product));
    }

}