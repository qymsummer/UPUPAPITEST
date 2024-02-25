package com.auto.bvtcase.testcase.rfmbiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShouCiGouMaIRiQi {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "首次购买日期"
    )
    public void beforeMethod(){
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);}

    @Test(description = "首次购买日期")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/rfmbiaoqian/首次购买日期.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("SELECT\n" +
                "\tcount( DISTINCT a.uni_id ) \n" +
                "FROM\n" +
                "\tccms_customer_anta a STRAIGHT_JOIN label_rfm_tenant_anta b ON b.uni_id = a.uni_id \n" +
                "\tAND b.first_created <= '2021-11-02 23:59:59' \n" +
                "\tAND b.tenant = 'anta'");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id ) ");
        Assert.assertEquals(api,sql);
    }
}
