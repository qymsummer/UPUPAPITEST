package com.auto.test;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;

public class HttpUtil1 {
    public static HttpResponse post(String url, String key, String value, String jsonObject){
        HttpResponse res = HttpRequest.post(url).header(key,value)
                .body(jsonObject)
                .execute();
        return res;
    }
    public static String post(String url, JSONObject jsonObject){
        return  HttpRequest.post(url)
                .body(String.valueOf(jsonObject))
                .execute().body();
    }
    public static HttpResponse post1(String url, String key, String value, String jsonObject){
        HttpResponse res = HttpRequest.post(url).header(key,value)
                .body(jsonObject).execute();
        res.getStatus();
        return res;
    }
}
