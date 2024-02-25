package com.auto.utils;

import com.alibaba.fastjson.JSONObject;
import com.auto.config.TestConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestApi {
    public static String getApi(String path, String token) throws SQLException {
        JSONObject jsonObject = JsonUtil.readJson(path);
        String post = HttpUtil.post(TestConfig.calcNumberurl,"x-token",token
                ,jsonObject.toString());

       return post;

    }
    public static ResultSet getSql(String sql) throws SQLException {
        PreparedStatement a = ConntMySQL.connMysqlPrepare(sql);
        ResultSet resultSet = a.executeQuery();
        return resultSet;
    }
}
