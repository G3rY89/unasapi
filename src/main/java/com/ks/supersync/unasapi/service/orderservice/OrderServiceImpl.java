package com.ks.supersync.unasapi.service.orderservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.controller.UnasEndpoints;
import com.ks.supersync.unasapi.service.unasauthservice.UnasAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UnasAuthService unasAuthService;

    OkHttpClient client = new OkHttpClient();

	@Override
	public String getOrdersForUgyvitel(String apiKey) throws JAXBException, IOException {
        Request getCustomersRequest = new Request.Builder()
            .url(UnasEndpoints.GETORDERS.toString())
            .get()
            .addHeader("Authorization", unasAuthService.getToken(apiKey))
            .build();
        Response response = client.newCall(getCustomersRequest).execute();

    return response.body().string();
	}

    @Override
    public String setOrdersToUnas(String apiKey, String Orders) throws JAXBException, IOException {
        
        MediaType mediaType = MediaType.parse("application/xml");

        RequestBody body = RequestBody.create(mediaType, Orders.toString());

        String token = unasAuthService.getToken(apiKey);

        Request setOrderRequest = new Request.Builder()
            .url(UnasEndpoints.SETORDERS.toString())
            .post(body)
            .addHeader("Authorization", token)
            .build();
        Response response = client.newCall(setOrderRequest).execute();

        return response.body().string();
    }

}