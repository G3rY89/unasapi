package com.ks.supersync.unasapi.service.stockservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.controller.UnasEndpoints;
import com.ks.supersync.unasapi.service.unasauthservice.UnasAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.*;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    UnasAuthService unasAuthService;

    OkHttpClient client = new OkHttpClient();


    @Override
    public String setStocksToUnas(String apiKey, String Stocks) throws JAXBException, IOException {
        
        MediaType mediaType = MediaType.parse("application/xml");

        RequestBody body = RequestBody.create(mediaType, Stocks.toString());

        String token = unasAuthService.getToken(apiKey);

        Request setStockRequest = new Request.Builder()
            .url(UnasEndpoints.SETSTOCKS.toString())
            .post(body)
            .addHeader("Authorization", token)
            .build();
        Response response = client.newCall(setStockRequest).execute();

        return response.body().string();
    }


}