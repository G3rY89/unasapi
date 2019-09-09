package com.ks.supersync.unasapi.service.productservice;

import com.ks.supersync.unasapi.controller.UnasEndpoints;
import com.ks.supersync.unasapi.service.unasauthservice.UnasAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

import java.io.IOException;

import okhttp3.*;


@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  UnasAuthService unasAuthService;

  OkHttpClient client = new OkHttpClient();

  @Override
  public String getProductsForUgyvitel(String apiKey) throws JAXBException, IOException {

    Request getProductRequest = new Request.Builder()
        .url(UnasEndpoints.GETPRODUCTS.toString())
        .get()
        .addHeader("Authorization", unasAuthService.getToken(apiKey))
        .build();
    Response response = client.newCall(getProductRequest).execute();

    return response.body().string();
  }

  @Override
  public Object setProductToUnas(String apiKey, Object Products) throws JAXBException, IOException {

    MediaType mediaType = MediaType.parse("application/xml");

    RequestBody body = RequestBody.create(mediaType, Products.toString());

    String token = unasAuthService.getToken(apiKey);

    Request setProductRequest = new Request.Builder()
        .url(UnasEndpoints.SETPRODUCTS.toString())
        .post(body)
        .addHeader("Authorization", token)
        .build();
    Response response = client.newCall(setProductRequest).execute();

    return response.body().string();

  }

}