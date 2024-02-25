package com.auto.config;


import org.apache.http.client.CookieStore;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Description ApiAutoTest
 * Create by qym on 2020/5/7 11:20
 * @author qym
 */

public class TestConfig {

    /**
     *
     */
    public static String calcNumberurl;
    public static String clustering;
    public static String interFaceAuthOritylist;
    public static CookieStore store;
    public static DefaultHttpClient client = new DefaultHttpClient();
}
