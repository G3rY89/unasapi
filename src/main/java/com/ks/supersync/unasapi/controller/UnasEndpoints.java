package com.ks.supersync.unasapi.controller;

public enum UnasEndpoints {
    LOGIN("https://api.unas.eu/shop/login"),
    GETPRODUCTS("https://api.unas.eu/shop/getProduct"),
    SETPRODUCTS("https://api.unas.eu/shop/setProduct"),
    GETCUSTOMERS("https://api.unas.eu/shop/getCustomer"),
    SETCUSTOMERS("https://api.unas.eu/shop/setCustomer"),
    GETORDERS("https://api.unas.eu/shop/getOrder"),
    SETORDERS("https://api.unas.eu/shop/setOrder"),
    SETCATEGORIES("https://api.unas.eu/shop/setCategory"),
    SETSTOCKS("https://api.unas.eu/shop/setStock");

    public final String url;

    UnasEndpoints(String url) {
        this.url = url;
    }

    public String toString(){
        return url;
    }
}