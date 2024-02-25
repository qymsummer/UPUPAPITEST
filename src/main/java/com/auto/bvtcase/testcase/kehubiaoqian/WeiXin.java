package com.auto.bvtcase.testcase.kehubiaoqian;

import com.alibaba.fastjson.JSONObject;
import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WeiXin {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "客户标签"
    )
    public void beforeMethod(){
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);}


    @Test(description = "当前可用积分")
    public void testGetApi(){
        JSONObject jsonObject = JsonUtil.readJson("src/main/java/com/auto/data/kehubiaoqian/weixin/weixinNo.json");
        String post = HttpUtil.post(TestConfig.calcNumberurl,"x-token",token
                ,jsonObject.toString());
        System.out.println(JsonParseUtil.parseJson(post).get("data"));
    }
}
