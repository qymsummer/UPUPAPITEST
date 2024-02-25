//package com.auto.test;
//
//import com.shuyun.api.sign.SignConvertUtil;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//public class adsa {
//    public static void main(String[] args) {
//
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar cal=Calendar.getInstance();
//        String timestamp=sdf.format(cal.getTime());
//        vars.put("Timestamp",timestamp);
//
//        String callerService="meta-mgmt";
//        String contextPath="loyalty2-interface";
//        String version="1.0";
//        String serviceSecret="6d657hW7f7YlQawnIZLL2";
//        String requestPath=sampler.getUrl().getPath().substring(contextPath.length()+version.length()+2);
//
//        vars.put("requestPath",requestPath);
//
//        String sign=SignConvertUtil.generateSign(callerService,contextPath,version,timestamp,serviceSecret,requestPath);
//        vars.put("Sign",sign);
//    }
//}
