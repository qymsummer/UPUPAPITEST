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

public class ZuiHouYiCiGouMaiPingTai {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "最后一次购买平台"
    )
    public void beforeMethod(){
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);}


    @Test(description = "最后一次购买平台")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/kehubiaoqian/最后一次购买平台.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("\n" +
                "SELECT\n" +
                "count( DISTINCT a.uni_id )\n" +
                "FROM\n" +
                "ccms_customer_anta a STRAIGHT_JOIN label_rfm_tenant_anta b ON b.uni_id = a.uni_id\n" +
                "AND b.last_plat_code IN ( 'JOS' )\n" +
                "AND b.tenant = 'anta'\n" +
                "AND 1 = 1\n" +
                "WHERE\n" +
                "1 = 1");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id )");
        Assert.assertEquals(api,sql);
    }
}
