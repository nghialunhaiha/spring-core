package org.led.simba.product.controller;

import org.core.controller.BaseController;
import org.led.simba.product.LEDProductItem;
import org.led.simba.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nghia on 11-09-2016.
 */
@Controller
@RequestMapping(value = "/item/")
public class ProductItemController extends BaseController{

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/detail-page/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LEDProductItem> getItemDetailById(@PathVariable("id") long itemId) {
//        LEDProductItem ledProductItem = productService.getById(itemId);
        return null;
    }
}
