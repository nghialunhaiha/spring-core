package org.led.simba.product;

import org.junit.Assert;
import org.junit.Test;
import org.led.simba.BaseServiceTest;
import org.led.simba.product.ProductItem.ColorTemp;
import org.led.simba.product.ProductItem.LEDType;
import org.led.simba.product.ProductItem.PowerSource;
import org.led.simba.product.ProductItem.SubType;
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
        productItem.setModelNumber("model number LED_MODULE");
        productItem.setSubType(SubType.LED_MODULE);
        productItem.setColorTemp(ColorTemp.T_3000K);
        productItem.setLedType(LEDType.LED_5050);
        productItem.setTitle("LED_MODULE");
        productService.create(productItem);

        productItem.setModelNumber("model number LED_MAXTRIX");
        productItem.setSubType(SubType.LED_MAXTRIX);
        productItem.setColorTemp(ColorTemp.T_4500K);
        productItem.setLedType(LEDType.LED_5730);
        productItem.setTitle("LED_MAXTRIX");
        productService.create(productItem);

        productItem.setModelNumber("model number BOARD");
        productItem.setSubType(SubType.BOARD);
        productItem.setColorTemp(ColorTemp.T_5000K);
        productItem.setLedType(LEDType.LED_F5);
        productItem.setTitle("BOARD");
        productService.create(productItem);

        productItem.setModelNumber("model number LED_TRIP");
        productItem.setSubType(SubType.LED_STRIP);
        productItem.setTitle("LED_TRIP");
        productItem.setColorTemp(ColorTemp.T_6000K);
        productItem.setLedType(LEDType.LED_F8);
        productItem.setPowerSource(PowerSource.DC);
        productService.create(productItem);

        productItem.setModelNumber("model number POWER_SOURCE");
        productItem.setSubType(SubType.POWER_SOURCE);
        productItem.setTitle("POWER_SOURCE");
        productItem.setLedType(LEDType.LED_LINK);
        productItem.setPowerSource(PowerSource.AC);
        productItem.setColorTemp(ColorTemp.T_3000K);
        productService.create(productItem);

        Assert.assertNotEquals(0, productService.list().size());
    }
}
