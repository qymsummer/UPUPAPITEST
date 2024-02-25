package com.auto.bvtcase.testcase.dingdanxingweichaxun;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Supreme
 */
public class AnDingDanZhiBiaoChaXun {
    String token = GetToken.token();
    @BeforeMethod(
            description = "按订单指标查询"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);
    }

    @Test(description = "按订单指标查询")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/dingdanxingweichaxun/按订单指标查询.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("select count(distinct lt00_0.uni_id) from ccms_customer_anta as lt00_0 STRAIGHT_JOIN ccms_order_anta AS lt06_1 ON lt06_1.uni_id=lt00_0.uni_id AND lt06_1.trade_discount_fee<=1000 AND lt06_1.created>='2020-12-02 00:00:00' AND lt06_1.payment>=10 AND lt06_1.payment<=1000 AND lt06_1.created<='2021-12-01 23:59:59' AND lt06_1.trade_discount_fee>=10 AND lt06_1.created>date_sub(now() , interval 730 day) WHERE 1=1 \n");
        Integer sql = GetSQL.getSQL(rs,"count(distinct lt00_0.uni_id)");
        Assert.assertEquals(api,sql);
    }
}