package com.auto.test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test {
    @Description("Description注解：验证主页面 test 2")
    @Test
    public void baseTest2() throws InterruptedException {
        Assert.assertTrue(true, "测试示例 ");
    }
}