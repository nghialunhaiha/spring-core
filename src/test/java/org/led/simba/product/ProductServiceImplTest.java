package org.led.simba.product;

import org.core.json.JsonUTils;
import org.junit.Test;
import org.led.simba.BaseServiceTest;
import org.led.simba.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nghialun on 12/10/2016.
 */
public class ProductServiceImplTest extends BaseServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void createProduct() {
        ProductItem productItem = new ProductItem();
        productItem.setModelNumber("model number 1");
        productItem.setSubType(SubType.LED_MAXTRIX);
        productItem.setTitle("product title");
        productService.create(productItem);
        System.out.println("created");
        System.out.println(JsonUTils.toJson(productService.list()));
    }
}
