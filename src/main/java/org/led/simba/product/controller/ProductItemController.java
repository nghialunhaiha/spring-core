package org.led.simba.product.controller;

import org.core.controller.BaseController;
import org.led.simba.product.ProductItem;
import org.led.simba.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Nghia on 11-09-2016.
 */
@Controller
@RequestMapping(value = "/prd/")
public class ProductItemController extends BaseController{

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductItem> getItemDetailById(@PathVariable("id") long itemId) {
//        LEDProductItem ledProductItem = productService.getById(itemId);
        return null;
    }

    @RequestMapping(value = {"/mgmt/", "/mgmt"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductItem> createProductItem(@RequestBody ProductItem productItem, UriComponentsBuilder uriBuilder){
        // check exist
        // validate
        // call save in product service
        System.out.print("call create product item");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/detail/{id}").buildAndExpand(productItem.getId()).toUri());
        return new ResponseEntity<ProductItem>(headers, HttpStatus.CREATED);
    }
}

