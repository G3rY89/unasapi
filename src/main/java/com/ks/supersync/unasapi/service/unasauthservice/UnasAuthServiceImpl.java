package com.ks.supersync.unasapi.service.unasauthservice;

import com.ks.supersync.unasapi.controller.UnasEndpoints;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UnasAuthServiceImpl implements UnasAuthService {

    @Override
    public String getToken(String ApiKey) {
        RestTemplate restTemplate = new RestTemplate();

        String request = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><Params><ApiKey>"+ApiKey+"</ApiKey></Params>";

        HttpEntity<String> entity = new HttpEntity<String>(request);
        String response = restTemplate.postForObject(UnasEndpoints.LOGIN.toString(), entity, String.class);
        Document doc = Jsoup.parse(response, "", Parser.xmlParser());
        
        return doc.select("Login").select("Token").text();
    }

}