package com.auto.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;

public class HttpUtil {
    public static String post(String url, String key, String value, String jsonObject){

       return HttpRequest.post(url).header(key,value)
                .body(jsonObject)
                .execute().body();


    }
    public static String post(String url, JSONObject jsonObject){
        return  HttpRequest.post(url)
                .body(String.valueOf(jsonObject))
                .execute().body();
    }
    public static HttpResponse postHttpResponse(String url, String key, String value, String jsonObject){
        return HttpRequest.post(url).header(key,value)
                .body(jsonObject).execute();

    }
}
