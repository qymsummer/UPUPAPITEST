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

public class MaiGuoDePingTai {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "买过的平台"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);}
    @Test(description = "买过的平台")
    public void testGetApi() throws SQLException {
       Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/kehubiaoqian/买过的平台.json",token)).get("data").toString());
       ResultSet rs = RequestApi.getSql("SELECT\n" +
               "\tcount( DISTINCT a.uni_id ) \n" +
               "FROM\n" +
               "\tccms_customer_anta a STRAIGHT_JOIN label_rfm_tenant_anta b ON b.uni_id = a.uni_id \n" +
               "\tAND ( ( b.all_plat_code LIKE '%TAOBAO%' OR b.all_plat_code LIKE '%JOS%' OR b.all_plat_code LIKE '%DD%' ) ) \n" +
               "\tAND b.tenant = 'anta' \n" +
               "\tAND 1 = 1 \n" +
               "WHERE\n" +
               "\t1 = 1");
       Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id )");
       Assert.assertEquals(api,sql);
    }
}
