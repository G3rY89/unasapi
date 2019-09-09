package com.ks.supersync.unasapi.service.productservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface ProductService {

    public String getProductsForUgyvitel(String apiKey) throws JAXBException, IOException;

    public Object setProductToUnas(String apiKey, Object Products) throws JAXBException, IOException;
    
}