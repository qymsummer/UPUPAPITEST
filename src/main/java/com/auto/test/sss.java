package com.auto.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sss {
    public static void main(String[] args) throws IOException, InterruptedException {

        //String[] args1=new String[]{"python","D:\\pyworkpeace\\9_30_1.py"};
        String command = "python E:\\PythonCode\\olap\\py\\code\\testheader.py";
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(command);
        //System.out.println(pr);
        pr.waitFor();

        BufferedReader b = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        StringBuilder response = new StringBuilder();
        while ((line = b.readLine()) != null) {
            response.append(line);
        }

        String response_data = response.toString();

        System.out.println(response_data);
    }
}
