package com.auto.test;

import cn.hutool.core.util.RuntimeUtil;

public class s {
    public static void main(String[] args) {
        String str = RuntimeUtil.execForStr("ipconfig");
        System.out.println(str);
    }
}
