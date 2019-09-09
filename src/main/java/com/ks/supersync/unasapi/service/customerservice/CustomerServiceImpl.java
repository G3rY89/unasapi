package com.ks.supersync.unasapi.service.customerservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;


import com.ks.supersync.unasapi.controller.UnasEndpoints;
import com.ks.supersync.unasapi.service.unasauthservice.UnasAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    UnasAuthService unasAuthService;

    OkHttpClient client = new OkHttpClient();

    @Override
    public String getCustomersForUgyvitel(String apiKey) throws JAXBException, IOException {
        Request getCustomersRequest = new Request.Builder()
            .url(UnasEndpoints.GETCUSTOMERS.toString())
            .get()
            .addHeader("Authorization", unasAuthService.getToken(apiKey))
            .build();
        Response response = client.newCall(getCustomersRequest).execute();
    
        return response.body().string();
    }

}