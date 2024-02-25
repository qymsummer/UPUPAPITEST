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

public class ShouCiGouMaiDianPu {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "首次购买店铺"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);}

    @Test(description = "首次购买店铺")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/kehubiaoqian/首次购买店铺.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("\n" +
                "SELECT\n" +
                "count( DISTINCT a.uni_id )\n" +
                "FROM\n" +
                "ccms_customer_anta a STRAIGHT_JOIN label_rfm_tenant_anta b ON b.uni_id = a.uni_id\n" +
                "AND b.first_uni_shop_id IN (\"YHD|192090\",\"JOS|66971\",\"JOS|66636\",\"JOS|69056\",\"JOS|72557\",\"JOS|95817\",\"JOS|93993\",\"TAOBAO|106096685\",\"TAOBAO|106308957\",\"TAOBAO|108281044\",\"TAOBAO|112680529\",\"TAOBAO|112767246\",\"TAOBAO|162598344\",\"TAOBAO|160103821\",\"TAOBAO|230790003\",\"TAOBAO|509312726\",\"TAOBAO|60790435\",\"TAOBAO|65305757\",\"TAOBAO|72452604\",\"TAOBAO|73149983\",\"TAOBAO|485527416\",\"TAOBAO|385220982\",\"TAOBAO|217976300\",\"TAOBAO|279336394\",\"DD|13433\",\"JOS|124510\",\"JOS|136923\",\"JOS|38725\",\"JOS|37360\")\n" +
                "AND b.tenant = 'anta'\n" +
                "AND 1 = 1\n" +
                "WHERE\n" +
                "1 = 1");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id )");
        Assert.assertEquals(api,sql);
    }
}
