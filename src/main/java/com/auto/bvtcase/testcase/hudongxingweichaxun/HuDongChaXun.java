package com.auto.bvtcase.testcase.hudongxingweichaxun;

import com.auto.config.TestConfig;
import com.auto.model.InterfaceName;
import com.auto.utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HuDongChaXun {
    String token = GetToken.token();
    @BeforeMethod(
            description = "互动查询"
    )
    public void beforeMethod() {
        TestConfig.calcNumberurl= ConfigFile.getUrl("prod.uri", InterfaceName.calcNumber);
    }

    @Test(description = "互动查询")
    public void testGetApi() throws SQLException {
        Integer api = JsonParseUtil.parseType(JsonParseUtil.parseJson(RequestApi.getApi("src/main/java/com/auto/data/hudongxingweichaxun/互动查询.json",token)).get("data").toString());
        ResultSet rs = RequestApi.getSql("select count(distinct lt00_0.uni_id) from ccms_customer_anta as lt00_0 STRAIGHT_JOIN interaction_anta AS lt10_1 ON lt10_1.uni_id=lt00_0.uni_id AND lt10_1.interaction_time>='2021-09-03 00:00:00' AND lt10_1.interaction_time<='2021-12-01 23:59:59' AND lt10_1.interaction_type in (\"unlimited\",\"ACTIVITY_TASK\",\"ADDON_ITEM\",\"BIG_TURNTABLE\",\"COMPLETE_USERINFO\",\"CUMULATIVE_SIGN\",\"DAILY_LOOTING\",\"FAVORITE\",\"FAVORITE_ITEM\",\"FIND_ANSWERS\",\"GROUP_BUYING\",\"GUESS_PRICE\",\"HEROCRAFT_TWICE\",\"INVITATION\",\"INVITATION_ADDON_ITEM\",\"INVITATION_FAVORITE_ITEM\",\"INVITE_COLLAR_CARD\",\"INVITE_MEMBERSHIP\",\"INVITE_RANK_MEMBERSHIP\",\"ITEMBROWSE\",\"LOTTERY\",\"MEMBERSHIP_CARD\",\"PUZZLE\",\"QUESTIONNAIRE\",\"RANK\",\"RED_ENVELOPE\",\"SCRATCH_CARD\",\"SHAKE_MANIA\",\"SIGN\",\"SMASH_EGG\",\"SUPPLEMENT\",\"TRADE_CONFIRM\",\"TRADE_RATE\",\"TREASURE\",\"TRIAL_APPLY\",\"VOTE\",\"WORD\",\"ZERO_TRIAL\") AND lt10_1.uni_shop_id in ( \"TAOBAO|106096685\",\"TAOBAO|106308957\",\"TAOBAO|108281044\",\"TAOBAO|112767246\",\"TAOBAO|160103821\",\"TAOBAO|217976300\",\"TAOBAO|230790003\",\"TAOBAO|279336394\",\"TAOBAO|385220982\",\"TAOBAO|60790435\",\"TAOBAO|72452604\",\"TAOBAO|73149983\") AND lt10_1.interaction_time>date_sub(now() , interval 90 day) WHERE 1=1 \n");
        Integer sql = GetSQL.getSQL(rs,"count(distinct lt00_0.uni_id)");
        Assert.assertEquals(api,sql);
    }
}
