package com.ks.supersync.unasapi.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.service.customerservice.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController{

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/getcustomers_fromunas", method = RequestMethod.GET, produces = "application/xml")
    public Object getCustomerFromUnas(@RequestHeader("ApiKey") String apiKey) throws JAXBException, IOException{
        return customerService.getCustomersForUgyvitel(apiKey);
    }

    @RequestMapping(value = "/setcustomers_tounas", method = RequestMethod.POST, produces = "application/xml")
    public Object setCustomersToUnas(@RequestHeader("ApiKey") String apiKey, @RequestBody String Customers) throws JAXBException, IOException{
        return customerService.setCustomersToUnas(apiKey, Customers);
    }
}