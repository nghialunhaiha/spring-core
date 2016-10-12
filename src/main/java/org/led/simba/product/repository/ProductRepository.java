package org.led.simba.product.repository;

import java.util.List;

import org.led.simba.product.ProductItem;

/**
 * Created by Nghia on 27-09-2016.
 */
public interface ProductRepository {
    boolean isExist(ProductItem productItem);

    ProductItem create(ProductItem productItem);

    ProductItem update(ProductItem productItem);

	List<ProductItem> list();
}
