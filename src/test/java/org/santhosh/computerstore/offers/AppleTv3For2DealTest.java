package org.santhosh.computerstore.offers;

import org.junit.jupiter.api.Test;
import org.santhosh.computerstore.models.Product;
import org.santhosh.computerstore.models.Sku;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

class AppleTv3For2DealTest {

    Offer offer;
    List<Product> products;
    List<Product> modifiedProducts;
    Product product;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        offer = new AppleTv3For2Deal();
        product = new Product(Sku.ATV);
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
    void testForNoOffer() {
        products.add(product);
        modifiedProducts = offer.modifyProducts(products);
        assertThat(modifiedProducts, hasItem(product));
    }

    @Test
    void testForOffer() {
        products.add(new Product(Sku.ATV));
        products.add(new Product(Sku.ATV));
        products.add(new Product(Sku.ATV));
        modifiedProducts = offer.modifyProducts(products);
        product.setDiscountedPrice(109.50);
        assertThat(modifiedProducts, hasItem(product));
    }
}