package com.ks.supersync.unasapi.service.orderservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface OrderService {

    public String getOrdersForUgyvitel(String apiKey) throws JAXBException, IOException;

    public String setOrdersToUnas(String apiKey, String Orders) throws JAXBException, IOException;
    
}