package org.led.simba.product.service;

import java.util.List;

import org.led.simba.product.ProductItem;

/**
 * Created by Nghia on 11-09-2016.
 */
public interface ProductService {
    boolean isExist(ProductItem productItem);

    ProductItem create(ProductItem productItem);

    ProductItem update(ProductItem productItem);
    
    List<ProductItem> list();

    List<ProductItem> importProduct();
}
