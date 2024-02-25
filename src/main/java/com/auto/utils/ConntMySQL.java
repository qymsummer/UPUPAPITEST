package com.auto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Supreme
 */
public class ConntMySQL {
    Connection con;
    public Connection getConnection(String ip,String port,String db,String root,String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");  System.out.println("数据库驱动加载成功");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+db+"?characterEncoding=UTF-8",root,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static PreparedStatement connMysqlPrepare(String sql) throws SQLException {
        ConntMySQL conn = new ConntMySQL();
        PreparedStatement  pstmt  = conn.getConnection("172.19.62.52","3306","olap_c","root","123456").prepareStatement(sql);
        return pstmt;
    }
}