package com.ks.supersync.unasapi.service.categoryservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.ks.supersync.unasapi.controller.UnasEndpoints;
import com.ks.supersync.unasapi.service.unasauthservice.UnasAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    UnasAuthService unasAuthService;

    OkHttpClient client = new OkHttpClient();

    @Override
    public String setCategoriesToUnas(String apiKey, String Categories) throws JAXBException, IOException {
        
        MediaType mediaType = MediaType.parse("application/xml");

        RequestBody body = RequestBody.create(mediaType, Categories.toString());

        String token = unasAuthService.getToken(apiKey);

        Request setCategoriesRequest = new Request.Builder()
            .url(UnasEndpoints.SETCUSTOMERS.toString())
            .post(body)
            .addHeader("Authorization", token)
            .build();
        Response response = client.newCall(setCategoriesRequest).execute();

        return response.body().string();
    }


}