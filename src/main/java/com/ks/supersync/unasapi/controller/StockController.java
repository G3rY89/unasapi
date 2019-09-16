package com.ks.supersync.unasapi.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.service.stockservice.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/setstocks_tounas", method = RequestMethod.POST, produces = "application/xml")
    public Object getCustomerFromUnas(@RequestHeader("ApiKey") String apiKey, @RequestBody String Stocks) throws JAXBException, IOException{
        return stockService.setStocksToUnas(apiKey, Stocks);
    }
}