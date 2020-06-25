package org.santhosh.computerstore.offers;

import org.santhosh.computerstore.models.Product;

import java.util.List;

/**
 *  Offer Contract to be used by all offers.
 *
 */
public interface Offer {
    List<Product> modifyProducts(List<Product> products);
}
