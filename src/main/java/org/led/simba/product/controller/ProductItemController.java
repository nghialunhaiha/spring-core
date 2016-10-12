package org.led.simba.product.controller;

import org.core.controller.BaseController;
import org.core.json.JsonUTils;
import org.led.simba.product.ProductItem;
import org.led.simba.product.service.ProductService;
import org.led.simba.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Nghia on 11-09-2016.
 */
@RestController
@RequestMapping(value = "/mgmgt/prd/")
public class ProductItemController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductItem getItemDetailById(@PathVariable("id") long itemId) {
//        LEDProductItem ledProductItem = productService.getById(itemId);
        return null;
    }

    @RequestMapping(value = {"item/", "item"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    //TODO  create annotation validate admin user.
    public ResponseEntity<ProductItem> createProductItem(@RequestBody ProductItem productItem, @RequestBody UserInfo userInfo, UriComponentsBuilder uriBuilder) {
        //TODO check exist
        //TODO  validate user, validate productItem.
        System.out.println("call in create item" + JsonUTils.toJson(userInfo));
        if (productService.isExist(productItem)) {
            return null;
        }

        ProductItem createdProduct = productService.create(productItem);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/detail/{id}").buildAndExpand(productItem.getId()).toUri());
        return new ResponseEntity<ProductItem>(createdProduct, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"item/{id}/", "item/{id}"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductItem> updateProductItem(@PathVariable("id") String productId, @RequestBody ProductItem productItem, UriComponentsBuilder uriBuilder) {
        if (productService.isExist(productItem)) {
            return null;
        }
        ProductItem updatedItem = productService.update(productItem);
        return new ResponseEntity<ProductItem>(updatedItem, HttpStatus.OK);
    }
}

