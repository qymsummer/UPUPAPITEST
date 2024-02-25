package com.auto.bvtcase.testcase.renqunhuaxiang;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class xingbiezhanbi {

    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "性别占比"
    )
    public void beforeMethod() {
        TestConfig.clustering = ConfigFile.getUrl("prod.uri",InterfaceName.clustering);
    }
    public static String getUrl(){
        String url =  TestConfig.clustering+"sex/10148";
        return url;
    }
    @Test
    public void testGetDiQu() throws SQLException {
        String result = HttpRequest.get(getUrl()).header("x-token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6InNqeWoiLCJ1c2VySWQiOjEwNzU0NTQyLCJ1c2VyVHlwZSI6ImtmeHQiLCJ1c2VyTmFtZSI6IuaVsOS6keaKgOacr-aUr-aMgTp5aW1pbmcucWlhbyIsImV4dCI6MTYzODU0NTcyMzgzMCwiaWF0IjoxNjM4NTAyNTIzODMwLCJjb3JwSWQiOm51bGwsImJ1c2luZXNzVXNlcklkIjpudWxsfQ.CbW12Eo42Bco2gtcZ0wmBqgUWx8MuIFAUGbDGjhdBIw").execute().body();
        JSONArray ja = JSONArray.parseArray(result);
       //System.out.println(ja);
        //System.out.println(((JSONObject)ja.get(0)).get("count"));
        String sql = "SELECT sex, COUNT(8) FROM ( SELECT CASE WHEN gender = 'M' THEN '男' WHEN gender = 'F' THEN '女' ELSE '未知' END AS sex FROM ccms_customer_sjyj )as total GROUP by sex;\n";
        PreparedStatement a = ConntMySQL.connMysqlPrepare(sql);
        ResultSet resultSet = a.executeQuery();
        List list = new ArrayList();
        list.add(resultSet);

        System.out.println(list);
        for(Object str : list){

        }

//        List list = new ArrayList();
//        while(resultSet.next())
//        {
//            string = resultSet.getString("COUNT(8)");
//            list.add(string);
//        }
//        System.out.println(list);

    }
    }


