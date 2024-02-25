package com.auto.bvtcase.testcase.huiyuankabiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KaiKaDianPu {
    String token = GetToken.token();
    @BeforeMethod(
            description = "开卡店铺"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);
    }

    @Test(description = "开卡店铺")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/huiyuankabiaoqian/开卡店铺.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("SELECT\n" +
                "\tcount( DISTINCT a.uni_id ) \n" +
                "FROM\n" +
                "\tccms_customer_anta AS a STRAIGHT_JOIN (\n" +
                "\tSELECT\n" +
                "\t\tltp0.uni_id,\n" +
                "\t\tb.STATUS,\n" +
                "\t\tltp0.card_plan_id,\n" +
                "\t\tb.available_point,\n" +
                "\t\tb.grade_period,\n" +
                "\t\tb.grade,\n" +
                "\t\tb.created,\n" +
                "\t\tb.uni_shop_id \n" +
                "\tFROM\n" +
                "\t\tlp3_uni_member_anta AS ltp0 STRAIGHT_JOIN member_anta AS b ON ltp0.card_plan_id = b.card_plan_id \n" +
                "\t\tAND ltp0.member_id = b.member_id \n" +
                "\t) AS c ON c.uni_id = a.uni_id \n" +
                "\tAND c.uni_shop_id IN ( \"TAOBAO|106096685\" ) \n" +
                "\tAND c.STATUS = 'NORMAL' \n" +
                "\tAND c.card_plan_id = '6938'");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id ) ");
        Assert.assertEquals(api,sql);
    }
}
