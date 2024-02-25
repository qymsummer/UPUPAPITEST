package com.auto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseCase {
    public WebDriver getDriver(String browser){
        WebDriver driver;
        if("chrome".equalsIgnoreCase(browser)){
            driver = new ChromeDriver();
        }else {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
