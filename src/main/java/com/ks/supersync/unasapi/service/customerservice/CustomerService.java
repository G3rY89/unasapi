package com.ks.supersync.unasapi.service.customerservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface CustomerService{

    public String getCustomersForUgyvitel(String apiKey) throws JAXBException, IOException;
    
    public Object setCustomersToUnas(String apiKey, String Customers) throws JAXBException, IOException;
}