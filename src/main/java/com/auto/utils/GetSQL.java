package com.auto.utils;

import com.alibaba.fastjson.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSQL {
//    public static String selectSql(String select) {
//            JSONObject jsonObject = JsonUtil.readJson("src/main/java/com/auto/data/mysql/mysqlmapper.json");
//            jsonObject.put("sql",select);
//            String post = HttpUtil.post("http://192.168.172.148:5053/ex_sql/",jsonObject).replaceAll("[\\[\\]]","");
//            return post;
//    }
    public static Integer getSQL(ResultSet rs1, String select) throws SQLException {
        String string = null;
        while(rs1.next())
        {
            string = rs1.getString(select);
        }
        return JsonParseUtil.parseType(string);
    }
}

