package com.ks.supersync.unasapi.service.customerservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.controller.UnasEndpoints;
import com.ks.supersync.unasapi.service.unasauthservice.UnasAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.*;

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
            System.out.println(getCustomersRequest.body().toString());
        Response response = client.newCall(getCustomersRequest).execute();
    
        return response.body().string();
    }

    @Override
    public Object setCustomersToUnas(String apiKey, String Customers) throws JAXBException, IOException {

        MediaType mediaType = MediaType.parse("application/xml");

        RequestBody body = RequestBody.create(mediaType, Customers.toString());

        String token = unasAuthService.getToken(apiKey);

        Request setCustomerRequest = new Request.Builder()
            .url(UnasEndpoints.SETCUSTOMERS.toString())
            .post(body)
            .addHeader("Authorization", token)
            .build();
        Response response = client.newCall(setCustomerRequest).execute();

        return response.body().string();
    }
}