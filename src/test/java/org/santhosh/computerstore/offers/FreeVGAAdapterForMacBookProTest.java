package org.santhosh.computerstore.offers;

import org.junit.jupiter.api.Test;
import org.santhosh.computerstore.models.Product;
import org.santhosh.computerstore.models.Sku;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FreeVGAAdapterForMacBookProTest {

    Offer offer;
    List<Product> products;
    List<Product> modifiedProducts;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        offer = new FreeVGAAdapterForMacBookPro();
        products = new ArrayList<>();
        modifiedProducts = new ArrayList<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        offer = null;
        products = null;
        modifiedProducts = null;
    }

    @Test
    public void testWithNoOffers(){
        products.add(new Product(Sku.ATV));
        products.add(new Product(Sku.IPD));
        modifiedProducts = offer.modifyProducts(products);
        Product product = new Product(Sku.VGA);
        product.setDiscountedPrice(30.00);
        assertThat(modifiedProducts, not(hasItem(product)));
    }

    @Test
    public void oneNewItemAdded(){
        products.add(new Product(Sku.ATV));
        products.add(new Product(Sku.MBP));
        modifiedProducts = offer.modifyProducts(products);
        assertEquals(3, modifiedProducts.size());
    }

    @Test
    public void twoNewItemsAdded(){
        products.add(new Product(Sku.MBP));
        products.add(new Product(Sku.MBP));
        modifiedProducts = offer.modifyProducts(products);
        assertEquals(4, modifiedProducts.size());
    }

    @Test
    public void verifyThatTheNewItemIsVGAAdapter(){
        products.add(new Product(Sku.ATV));
        products.add(new Product(Sku.MBP));
        modifiedProducts = offer.modifyProducts(products);
        Product product = new Product(Sku.VGA);
        product.setDiscountedPrice(30.00);
        assertThat(modifiedProducts, hasItem(product));
    }

    @Test
    public void verifyThatVGAAdapterPriceIsDiscounted(){
        products.add(new Product(Sku.MBP));
        products.add(new Product(Sku.VGA));
        modifiedProducts = offer.modifyProducts(products);
        Product product = new Product(Sku.VGA);
        product.setDiscountedPrice(30.00);
        assertThat(modifiedProducts, hasItem(product));
    }

}