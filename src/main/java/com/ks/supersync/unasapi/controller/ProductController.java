package com.ks.supersync.unasapi.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.service.productservice.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getproducts_fromunas", method = RequestMethod.GET, produces = "application/xml")
    public Object getProductFromUnas(@RequestHeader("ApiKey") String apiKey) throws JAXBException, IOException{
        return productService.getProductsForUgyvitel(apiKey);
    }

    @RequestMapping(value = "/setproducts_tounas", method = RequestMethod.POST, consumes = "application/xml")
    public Object setProductToUnas(@RequestHeader("ApiKey") String apiKey, @RequestBody String Products) throws JAXBException, IOException{
        return productService.setProductToUnas(apiKey, Products);
    }

}