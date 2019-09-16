package com.ks.supersync.unasapi.service.stockservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface StockService {

    public String setStocksToUnas(String apiKey, String Stocks) throws JAXBException, IOException;
}