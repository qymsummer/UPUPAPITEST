package com.auto.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonParseUtil {
    //String转Json
    public static JSONObject parseJson(String result){
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject;
    }
    //String转Integer
    public static Integer parseType(String result){
        Integer integer = Integer.valueOf(result);
        return integer;
    }

}
