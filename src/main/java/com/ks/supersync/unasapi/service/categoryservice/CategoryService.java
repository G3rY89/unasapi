package com.ks.supersync.unasapi.service.categoryservice;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface CategoryService {

    public String setCategoriesToUnas(String apiKey, String Categories) throws JAXBException, IOException;
}