package com.auto.test;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class DiQu {

    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");
    @BeforeMethod(
            description = "地区"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("qa.url",InterfaceName.calcNumber);
    }
    @Description("Description注解：验证主页面 test 2")
    @Test(description = "地区")
    public void testGetApi() throws SQLException{
        int r = 200;
        HttpResponse httpResponse = RequestApia.getApiTest("src/main/java/com/auto/data/kehubiaoqian/地区.json",TestConfig.calcNumberurl,token);
        if (httpResponse.getStatus()!=r){
            Assert.assertEquals(httpResponse.getStatus(),r);
            System.out.println(httpResponse.body());
        }else {
            Integer integer = JsonParseUtil.parseType(JSONObject.parseObject(httpResponse.body()).get("data").toString());
            System.out.println(integer);
        }
    }
}