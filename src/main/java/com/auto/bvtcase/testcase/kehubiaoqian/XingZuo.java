package com.auto.bvtcase.testcase.kehubiaoqian;

import com.alibaba.fastjson.JSONObject;
import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class XingZuo {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "星座"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);}

    @Test(description = "星座")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/kehubiaoqian/星座.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("select count(uni_id) from ccms_customer_anta");
        Integer sql = GetSQL.getSQL(rs,"count(uni_id))");
        Assert.assertEquals(api,sql);
    }
//    @Test
//    public void testGetBaiYangZuo(){
//        JSONObject jsonObject = JsonUtil.readJson("src/main/java/com/auto/data/kehubiaoqian/xingzuo/白羊座.json");
//        String post = HttpUtil.post(TestConfig.calcNumberurl,"x-token",token
//                ,jsonObject.toString());
//        System.out.println(JsonParseUtil.parseJson(post).get("data"));
//    }
//    @Test
//    public void testGetWeiZhi(){
//        JSONObject jsonObject = JsonUtil.readJson("src/main/java/com/auto/data/kehubiaoqian/xingzuo/未知.json");
//        String post = HttpUtil.post(TestConfig.calcNumberurl,"x-token",token
//                ,jsonObject.toString());
//        System.out.println(JsonParseUtil.parseJson(post).get("data"));
//    }
}
