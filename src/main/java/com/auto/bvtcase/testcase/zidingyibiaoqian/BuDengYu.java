package com.auto.bvtcase.testcase.zidingyibiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuDengYu {
    String token = GetToken.token();
    @BeforeMethod(
            description = "数值输入不等于小数"
    )
    public void beforeMethod(){
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);}

    @Test(description = "数值输入不等于小数")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/zidingyibiaoqian/数值输入不等于小数.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("SELECT\n" +
                "\tcount( DISTINCT a.uni_id ) \n" +
                "FROM\n" +
                "\tccms_customer_anta AS a STRAIGHT_JOIN tb_tag_customer_anta AS b ON b.uni_id = a.uni_id \n" +
                "\tAND b.tag_id = '5806' \n" +
                "\tAND b.tag_value != '1.10' \n" +
                "\tAND b.is_valid = 1");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id )");
        Assert.assertEquals(api,sql);
    }
}
