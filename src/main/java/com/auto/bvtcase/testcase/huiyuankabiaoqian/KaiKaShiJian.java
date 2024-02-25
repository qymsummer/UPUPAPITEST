package com.auto.bvtcase.testcase.huiyuankabiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KaiKaShiJian {
    String token = GetToken.token();
    @BeforeMethod(
            description = "开卡时间"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);
    }

    @Test(description = "开卡时间")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/huiyuankabiaoqian/开卡时间.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("SELECT\n" +
                "\tcount( DISTINCT lt00.uni_id ) \n" +
                "FROM\n" +
                "\tccms_customer_anta AS lt00 STRAIGHT_JOIN (\n" +
                "\tSELECT\n" +
                "\t\tltp0.uni_id,\n" +
                "\t\tltp1.STATUS,\n" +
                "\t\tltp0.card_plan_id,\n" +
                "\t\tltp1.available_point,\n" +
                "\t\tltp1.grade_period,\n" +
                "\t\tltp1.grade,\n" +
                "\t\tltp1.created,\n" +
                "\t\tltp1.uni_shop_id \n" +
                "\tFROM\n" +
                "\t\tlp3_uni_member_anta AS ltp0 STRAIGHT_JOIN member_anta AS ltp1 ON ltp0.card_plan_id = ltp1.card_plan_id \n" +
                "\t\tAND ltp0.member_id = ltp1.member_id \n" +
                "\t) AS lt05 ON lt05.uni_id = lt00.uni_id \n" +
                "\tAND lt05.STATUS = 'NORMAL' \n" +
                "\tAND lt05.created >= '2008-03-18 00:00:00' \n" +
                "\tAND lt05.created <= '2021-11-03 23:59:59' \n" +
                "\tAND lt05.card_plan_id = '6938' \n" +
                "\tAND 1 = 1 \n" +
                "WHERE\n" +
                "\t1 = 1");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT lt00.uni_id )");
        Assert.assertEquals(api,sql);
    }
}
