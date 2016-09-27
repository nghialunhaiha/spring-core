package org.led.simba.product.service.impl;

import org.led.simba.product.ProductItem;
import org.led.simba.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nghia on 11-09-2016.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
//    private
    @Override
    public boolean isExist(ProductItem productItem) {
        return false;
    }

    @Override
    public ProductItem create(ProductItem productItem) {

        return null;
    }

    @Override
    public ProductItem update(ProductItem productItem) {
        return null;
    }
}
