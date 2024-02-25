package com.auto.bvtcase.testcase.yingxiaochudachaxun;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShiJianYingXiaoChaXun {
    String token = GetToken.token();
    @BeforeMethod(
            description = "事件营销查询"
    )
    public void beforeMethod(){
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);}

    @Test(description = "事件营销查询")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/yingxiaochudachaxun/事件营销查询.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("select count(distinct lt00_0.uni_id) from ccms_customer_anta as lt00_0 STRAIGHT_JOIN marketing_anta AS lt09_1 ON lt09_1.uni_id=lt00_0.uni_id AND lt09_1.uni_shop_id in ( \"TAOBAO|217976300\",\"TAOBAO|279336394\",\"TAOBAO|106096685\",\"TAOBAO|106308957\",\"TAOBAO|108281044\",\"TAOBAO|112680529\",\"TAOBAO|112767246\",\"TAOBAO|160103821\",\"TAOBAO|162598344\",\"TAOBAO|230790003\",\"TAOBAO|509312726\",\"TAOBAO|60790435\",\"TAOBAO|65305757\",\"TAOBAO|72452604\",\"TAOBAO|73149983\",\"TAOBAO|485527416\",\"TAOBAO|385220982\" ) AND lt09_1.plat_code='TAOBAO' AND lt09_1.marketing_scene in ( \"-10027\",\"-10022\",\"-10008\",\"-10005\",\"-10002\",\"-10016,-10017,-10018\",\"-10015\",\"-10006\",\"-10001\",\"-10028\",\"-10020\",\"-10010\",\"-10011,-10021\",\"-10003\",\"-10024\",\"-10019\",\"-10012\",\"-10004\",\"-10013\",\"-10007\",\"-10023\",\"-10009\") AND lt09_1.marketing_type='SY_EVENT_MARKETING' AND lt09_1.marketing_time>='2021-09-03 00:00:00' AND lt09_1.marketing_time<='2021-12-01 23:59:59' AND lt09_1.marketing_time>date_sub(now() , interval 90 day) WHERE 1=1 \n");
        Integer sql = GetSQL.getSQL(rs,"count(distinct lt00_0.uni_id)");
        Assert.assertEquals(api,sql);
    }
}
