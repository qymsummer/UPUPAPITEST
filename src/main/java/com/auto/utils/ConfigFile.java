package com.auto.utils;
import com.auto.model.InterfaceName;
import java.util.Locale;
import java.util.ResourceBundle;


public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(String url,InterfaceName name) {
        String address = bundle.getString(url);
        String uri = "";
        String testUrl;
        if (name == InterfaceName.calcNumber) {
            uri = bundle.getString("calcNumber.uri");
        }
        if (name == InterfaceName.clustering) {
            uri = bundle.getString("clustering.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
}