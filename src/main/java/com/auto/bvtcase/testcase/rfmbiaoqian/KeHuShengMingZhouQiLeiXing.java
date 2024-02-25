package com.auto.bvtcase.testcase.rfmbiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KeHuShengMingZhouQiLeiXing {
    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");

    @BeforeMethod(
            description = "客户生命周期类型"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri",InterfaceName.calcNumber);}

    @Test(description = "客户生命周期类型")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/rfmbiaoqian/客户生命周期类型.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("SELECT\n" +
                "\tcount( DISTINCT a.uni_id ) \n" +
                "FROM\n" +
                "\tccms_customer_anta a STRAIGHT_JOIN label_rfm_tenant_anta b ON b.uni_id = a.uni_id \n" +
                "\tAND b.customer_type IN ( '1', '2', '3', '4', '5', '6', '7' ) \n" +
                "\tAND b.tenant = 'anta'");
        Integer sql = GetSQL.getSQL(rs,"count( DISTINCT a.uni_id )");
        Assert.assertEquals(api,sql);
    }
}
