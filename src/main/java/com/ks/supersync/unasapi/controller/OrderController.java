package com.ks.supersync.unasapi.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.service.orderservice.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController{

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/getorders_fromunas", method = RequestMethod.GET, produces = "application/xml")
    public Object getOrdersFromUnas(@RequestHeader("ApiKey") String apiKey) throws JAXBException, IOException{
        return orderService.getOrdersForUgyvitel(apiKey);
    }
}