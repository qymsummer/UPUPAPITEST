package com.auto.bvtcase.login;

import com.auto.utils.BaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
www
public class Login extends BaseCase {
    public WebDriver driver;
    //@Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://qa-qiushi6-ccms.shuyun.com/portal/index.html#/customerGrouping");
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void ccc() throws InterruptedException {

        Thread.sleep(500);
        Cookie c1 = new Cookie("_ati","9421170488154");
        Cookie c2 = new Cookie("x_session","f3681c4c567c4d7f99f670e780a4e94d");
        Cookie c3 = new Cookie("tenantId","qiushi6");
        Cookie c4 = new Cookie("sy-cook","c7771a3c3505650c9067c9e26d38a812");
        Cookie c5 = new Cookie("cid_yiming.qiao_shuyun.com","TUhrMGFUZHRNV2sxYmpObk5pNHhjVFJw");
        Cookie c6 = new Cookie("acw_tc","2f691d5c16354168071742839e8167c1fda3ac4b15a9b53438d6655e29");
        Cookie c7 = new Cookie("SDPID","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6InFpdXNoaTYiLCJ1c2VySWQiOjExODQ5ODIwLCJ1c2VyVHlwZSI6ImJ1aWxkLWluIiwidXNlck5hbWUiOiJ5aW1pbmcucWlhbyIsImV4dCI6MTYzNTQ2MDQ5NTM2NCwiaWF0IjoxNjM1NDE3Mjk1MzY0fQ.Xaf5htP0Jd_B8IZnErSLlc7Emfv3--8hewnhs6irL5U");
        Cookie c8 = new Cookie("JSESSIONID","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6InFpdXNoaTYiLCJ1c2VySWQiOjExODQ5ODIwLCJ1c2VyVHlwZSI6ImJ1aWxkLWluIiwidXNlck5hbWUiOiJ5aW1pbmcucWlhbyIsImV4dCI6MTYzNTQ2MDQ5NTM2NCwiaWF0IjoxNjM1NDE3Mjk1MzY0fQ.Xaf5htP0Jd_B8IZnErSLlc7Emfv3--8hewnhs6irL5U");
        Cookie c9 = new Cookie("ccmsRequestCredential","%7B%22id%22%3A%22eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6InFpdXNoaTYiLCJ1c2VySWQiOjExODQ5ODIwLCJ1c2VyVHlwZSI6ImJ1aWxkLWluIiwidXNlck5hbWUiOiJ5aW1pbmcucWlhbyIsImV4dCI6MTYzNTQ2MDQ5NTM2NCwiaWF0IjoxNjM1NDE3Mjk1MzY0fQ.Xaf5htP0Jd_B8IZnErSLlc7Emfv3--8hewnhs6irL5U%22%2C%22userId%22%3A11849820%2C%22username%22%3A%22yiming.qiao%22%2C%22sign%22%3A%22d18a18e14613613f8b7e01de9144717c%22%2C%22authenticatedTime%22%3A%222021-10-28T18%3A34%3A55.364%2B0800%22%2C%22expireTime%22%3A%222021-10-29T06%3A34%3A55.364%2B0800%22%2C%22tenantId%22%3A%22qiushi6%22%2C%22host%22%3A%22%22%2C%22remark%22%3Anull%2C%22mobile%22%3A%22%22%2C%22corpId%22%3Anull%2C%22businessUserId%22%3Anull%2C%22refreshToken%22%3A%22eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6InFpdXNoaTYiLCJ1c2VySWQiOjExODQ5ODIwLCJ1c2VyVHlwZSI6ImJ1aWxkLWluIiwidXNlck5hbWUiOiJ5aW1pbmcucWlhbyIsImV4dCI6MTYzNTQ2MDQ5NTM2NSwiaWF0IjoxNjM1NDE3Mjk1MzY0fQ.ujB9e6-5mEvmsLEzn1PRunUV2gBQLVGTgdFbdbVWhKY%22%2C%22verifyCode%22%3A%22%22%2C%22redirectURL%22%3A%22https%253A%252F%252Fqa-qiushi6-ccms.shuyun.com%252Fportal%252FtbLogin.html%22%2C%22appName%22%3A%22%E6%95%B0%E6%8D%AE%E8%B5%A2%E5%AE%B6%22%2C%22ati%22%3A%229421170488154%22%2C%22token%22%3Anull%2C%22password%22%3Anull%2C%22tenant_id%22%3Anull%2C%22authType%22%3A%22page%22%2C%22expired%22%3Afalse%7D");
        Thread.sleep(500);
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        driver.manage().addCookie(c3);
        driver.manage().addCookie(c4);
        driver.manage().addCookie(c5);
        driver.manage().addCookie(c6);
        driver.manage().addCookie(c7);
        driver.manage().addCookie(c8);
        driver.manage().addCookie(c9);
        driver.navigate().refresh();
        Thread.sleep(500);
        driver.get("https://qa-qiushi6-ccms.shuyun.com/portal/index.html#/customerGrouping");
        List<WebElement> ButtonElement = driver.findElements(By.className("cloud-input"));
        ButtonElement.get(0).sendKeys("yiming.qiao");
        ButtonElement.get(1).sendKeys("Qiaoyiming@123");
        driver.findElement(By.id("btn")).click();
        List<WebElement> ButtonElement2 = driver.findElements(By.className("btn-apply"));
        ButtonElement2.get(0).click();
    }
}
