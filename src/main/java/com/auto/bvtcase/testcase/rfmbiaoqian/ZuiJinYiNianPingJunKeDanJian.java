package com.auto.bvtcase.testcase.rfmbiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZuiJinYiNianPingJunKeDanJian {
    String token = GetToken.token();
    @BeforeMethod(
            description = "最近一年平均客单价"
    )
    public void beforeMethod(){
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);}

    @Test(description = "最近一年平均客单价")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/rfmbiaoqian/最近一年平均客单价.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("SELECT\n" +
                "\tcount( DISTINCT a.uni_id ) \n" +
                "FROM\n" +
                "\tccms_customer_anta a STRAIGHT_JOIN label_rfm_tenant_anta b ON b.uni_id = a.uni_id \n" +
                "\tAND b.year_avg_payment > 400.0 \n" +
                "\tAND b.tenant = 'anta'");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id )");
        Assert.assertEquals(api,sql);
    }
}
