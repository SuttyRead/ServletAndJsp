package com.ua.sutty.utils;

import java.util.ArrayList;
import java.util.List;

public class AvailableUrl {

    private List<String> url;

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    {
        url = new ArrayList<>();
        url.add("/");
        url.add("/home");
        url.add("/add");
        url.add("/edit");
        url.add("/login");
        url.add("/delete");
    }


}
