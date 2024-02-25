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

public class MaiGuoDeDianPu {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "买过的店铺"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);
    }

    @Test(description = "买过的店铺")
    public void testGetApi() throws SQLException {

        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/kehubiaoqian/买过的店铺.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("select count(distinct lt00_0.uni_id) from ccms_customer_anta as lt00_0 STRAIGHT_JOIN label_rfm_tenant_anta AS lt02_1 ON lt02_1.uni_id=lt00_0.uni_id AND lt02_1.tenant='anta' AND ( lt02_1.all_uni_shop_id like '%YHD|192090%' OR lt02_1.all_uni_shop_id like '%TAOBAO|72452604%' ) AND 1=1 WHERE 1=1\n");
        Integer sql = GetSQL.getSQL(rs,"count(distinct lt00_0.uni_id)");
        Assert.assertEquals(api,sql);  }
}
