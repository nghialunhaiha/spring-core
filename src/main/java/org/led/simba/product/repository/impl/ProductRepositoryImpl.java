package org.led.simba.product.repository.impl;

import org.core.repository.BaseRepository;
import org.led.simba.product.ProductItem;
import org.led.simba.product.repository.ProductRepository;

/**
 * Created by Nghia on 27-09-2016.
 */
public class ProductRepositoryImpl extends BaseRepository<ProductItem> implements ProductRepository {
    @Override
    public ProductItem create(ProductItem productItem) {
        return null;
    }

    @Override
    public boolean isExist(ProductItem productItem) {
        //  TODO: kiem tra  exist hay chua thi theo tung loai se kiem tra khac nhau,
        // co le nen check theo type. LEDTYPE = 5050 thi exist. :))
        return false;
    }

    @Override
    public ProductItem update(ProductItem productItem) {
        return null;
    }
}
