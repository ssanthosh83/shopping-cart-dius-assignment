package org.santhosh.computerstore;

import org.junit.jupiter.api.Test;
import org.santhosh.computerstore.offers.AppleTv3For2Deal;
import org.santhosh.computerstore.offers.FreeVGAAdapterForMacBookPro;
import org.santhosh.computerstore.offers.Offer;
import org.santhosh.computerstore.offers.SuperIPadBulkDiscountFor4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.santhosh.computerstore.models.Sku.*;

class CheckoutTest {

    Checkout checkout;
    List<Offer> priceRules;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        checkout = new Checkout();
        priceRules = new ArrayList<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        checkout = null;
        priceRules = null;
    }


    @Test
    public void scanAProduct(){
        checkout.scan(IPD);
        assertEquals(checkout.getProductList().size(), 1);
    }

    @Test
    public void scanMultipleItems(){
        checkout.scan(IPD);
        checkout.scan(MBP);
        checkout.scan(ATV);
        checkout.scan(VGA);
        assertEquals(checkout.getProductList().size(), 4);
    }

    @Test
    public void checkTotalPrice(){
        checkout.scan(IPD);
        checkout.scan(MBP);
        checkout.scan(ATV);
        checkout.scan(VGA);
        assertEquals(2089.48, checkout.getTotalPrice());
    }

    @Test
    public void testWithOfferAppleTv3For2(){
        Offer offer = new AppleTv3For2Deal();
        priceRules.add(offer);
        checkout = new Checkout(priceRules);

        checkout.scan(ATV);
        checkout.scan(ATV);
        checkout.scan(ATV);
        checkout.scan(VGA);

        assertEquals(249.00, checkout.getTotalPrice());
    }

    @Test
    public void testWithOfferSuperIPadBulkDiscountfor4(){
        Offer offer = new SuperIPadBulkDiscountFor4();
        priceRules.add(offer);
        checkout = new Checkout(priceRules);
        checkout.scan(IPD);
        checkout.scan(IPD);
        checkout.scan(IPD);
        checkout.scan(IPD);
        assertEquals(1999.96, checkout.getTotalPrice());
    }

    @Test
    public void testWithOfferFreeVGAAdapterForMacBookPro(){
        Offer offer = new FreeVGAAdapterForMacBookPro();
        priceRules.add(offer);
        checkout = new Checkout(priceRules);
        checkout.scan(MBP);
        checkout.scan(VGA);
        assertEquals(1399.99, checkout.getTotalPrice());
    }

    @Test
    public void testWithMultipleOffers1(){
        priceRules.add(new FreeVGAAdapterForMacBookPro());
        priceRules.add(new SuperIPadBulkDiscountFor4());
        priceRules.add(new AppleTv3For2Deal());

        checkout = new Checkout(priceRules);
        checkout.scan(ATV);
        checkout.scan(ATV);
        checkout.scan(ATV);
        checkout.scan(VGA);
        assertEquals(249.00, checkout.getTotalPrice());
    }

    @Test
    public void testWithMultipleOffers2(){
        priceRules.add(new FreeVGAAdapterForMacBookPro());
        priceRules.add(new SuperIPadBulkDiscountFor4());
        priceRules.add(new AppleTv3For2Deal());

        checkout = new Checkout(priceRules);
        checkout.scan(IPD);
        checkout.scan(ATV);
        checkout.scan(IPD);
        checkout.scan(ATV);
        checkout.scan(IPD);
        checkout.scan(IPD);
        checkout.scan(IPD);
        assertEquals(2718.95, checkout.getTotalPrice());
    }


    @Test
    public void testWithMultipleOffers3(){
        priceRules.add(new FreeVGAAdapterForMacBookPro());
        priceRules.add(new SuperIPadBulkDiscountFor4());
        priceRules.add(new AppleTv3For2Deal());

        checkout = new Checkout(priceRules);
        checkout.scan(IPD);
        checkout.scan(MBP);
        checkout.scan(VGA);

        assertEquals(1949.98, checkout.getTotalPrice());
    }

    @Test
    public void testWithMultipleOffers4(){
        priceRules.add(new FreeVGAAdapterForMacBookPro());
        priceRules.add(new SuperIPadBulkDiscountFor4());
        priceRules.add(new AppleTv3For2Deal());

        checkout = new Checkout(priceRules);
        checkout.scan(IPD);
        checkout.scan(MBP);

        assertEquals(1949.98, checkout.getTotalPrice());
    }



}