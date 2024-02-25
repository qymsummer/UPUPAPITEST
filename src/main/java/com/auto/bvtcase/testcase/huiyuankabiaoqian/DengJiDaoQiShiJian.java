package com.auto.bvtcase.testcase.huiyuankabiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DengJiDaoQiShiJian {
    String token = GetToken.token();
    @BeforeMethod(
            description = "等级到期时间"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);
    }

    @Test(description = "等级到期时间")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/huiyuankabiaoqian/等级到期时间.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("SELECT\n" +
                "count(DISTINCT lt00.uni_id)\n" +
                "FROM\n" +
                "ccms_customer_anta AS lt00 STRAIGHT_JOIN (\n" +
                "SELECT\n" +
                "a.uni_id,\n" +
                "b. STATUS,\n" +
                "a.card_plan_id,\n" +
                "b.available_point,\n" +
                "b.grade_period,\n" +
                "b.grade,\n" +
                "b.created,\n" +
                "b.uni_shop_id\n" +
                "FROM\n" +
                "lp3_uni_member_anta AS a STRAIGHT_JOIN member_anta AS b ON a.card_plan_id = b.card_plan_id\n" +
                "AND a.member_id = b.member_id\n" +
                ") AS c ON c.uni_id = lt00.uni_id\n" +
                "AND c.uni_shop_id IN ('TAOBAO|106096685')\n" +
                "AND c.grade_period >= '2021-11-04 00:00:00'\n" +
                "AND c. STATUS = 'NORMAL'\n" +
                "AND c.card_plan_id = '6938'");
        Integer sql = GetSQL.getSQL(rs,"count(DISTINCT lt00.uni_id)");
        Assert.assertEquals(api,sql);
    }
}
