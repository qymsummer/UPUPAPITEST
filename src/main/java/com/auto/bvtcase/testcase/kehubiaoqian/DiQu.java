package com.auto.bvtcase.testcase.kehubiaoqian;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.SQLException;


public class DiQu {

    String token = ReadFile.readFile("E:\\JavaCode\\DataYun\\src\\main\\java\\com\\auto\\data\\token\\token.txt");
    @BeforeMethod(
            description = "地区"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("qa.url",InterfaceName.calcNumber);
    }


    @Test(description = "地区")
    public void testGetApi() throws SQLException{
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/kehubiaoqian/地区.json",token)).get("data").toString());

        //ResultSet rs = RequestApi.getSql("select count(distinct lt00_0.uni_id) from ccms_customer_anta as lt00_0 WHERE ( ( lt00_0.state='22' AND lt00_0.city='220100000000' AND lt00_0.district='220103000000' ) ) AND 1=1 \n");
        //Integer sql = GetSQL.getSQL(rs,"count(distinct lt00_0.uni_id)");
        //Assert.assertEquals(api,sql);
        System.out.println(api);
    }
}
