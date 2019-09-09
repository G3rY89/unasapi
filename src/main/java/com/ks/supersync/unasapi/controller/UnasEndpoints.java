package com.ks.supersync.unasapi.controller;

public enum UnasEndpoints {
    LOGIN("https://api.unas.eu/shop/login"),
    GETPRODUCTS("https://api.unas.eu/shop/getProduct"),
    SETPRODUCTS("https://api.unas.eu/shop/setProduct"),
    GETCUSTOMERS("https://api.unas.eu/shop/getCustomer"),
    GETORDERS("https://api.unas.eu/shop/getOrder");

    public final String url;

    UnasEndpoints(String url) {
        this.url = url;
    }

    public String toString(){
        return url;
    }
}