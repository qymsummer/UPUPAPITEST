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

public class XingBie {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "性别"
    )
    public void beforeMethod(){
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);}
    @Test(description = "性别")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/kehubiaoqian/性别.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("select count(uni_id) from ccms_customer_anta where gender is null or gender = 'M'  or gender ='F'");
        Integer sql = GetSQL.getSQL(rs,"count(uni_id)");
        Assert.assertEquals(api,sql);       }

}

