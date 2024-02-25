package com.auto.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

public class ReadFile {
    public static String readFile(String path){
        FileReader fileReader = new FileReader(path);
        String result = fileReader.readString();
        return result;
    }
    public static String writeFile(String path){
        FileWriter writer = new FileWriter(path);
        writer.write("test");
        return null;
    }

}
