package com.auto.utils;

import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.auto.test.HttpUtil1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestApia {
    public static HttpResponse getApi(String path, String url, String token) throws SQLException {
        JSONObject jsonObject = JsonUtil.readJson(path);
        HttpResponse post = HttpUtil1.post(url,"x-token",token
                ,jsonObject.toString());
       return post;

    }
    public static ResultSet getSql(String sql) throws SQLException {
        PreparedStatement a = ConntMySQL.connMysqlPrepare(sql);
        ResultSet resultSet = a.executeQuery();
        return resultSet;
    }
    public static HttpResponse getApiTest(String path, String url, String token){
        JSONObject jsonObject = JsonUtil.readJson(path);
        HttpResponse httpResponse = HttpUtil.postHttpResponse(url,"x-token",token,jsonObject.toString());
        return httpResponse;
    }
}
