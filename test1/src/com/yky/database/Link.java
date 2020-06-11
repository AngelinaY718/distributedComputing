package com.yky.database;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Link  implements DataSource {
    private LinkedList<Connection> linkedList=new LinkedList<Connection>();

    public Link() {
        String user = "admin";
        String pwd = "Admin@123";

        //String user = "root";
        //String pwd = "lj0211";
        //String url = "jdbc:sqlserver://127.0.0.1:1433;databasename=分布式实验1";
        String url = "jdbc:mysql://39.101.217.212:3306/rpc?serverTimezone=GMT%2B8&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        //String url = "jdbc:mysql://localhost:3306/rpc?serverTimezone=GMT%2B8&useSSL=false";
        for(int i=0;i<10;i++){
            try {
                //选择SQLServerDriver驱动
                //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Class.forName("com.mysql.jdbc.Driver"); //classLoader,加载对应驱动
                //开始连接
               Connection conn = DriverManager.getConnection(url, user, pwd);
               linkedList.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("发生了奇怪的事情……");
            }

        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        final Connection conn = linkedList.removeFirst(); // 删除第一个连接返回
        return conn;
    }

    public void releaseConnection(Connection conn) {
        linkedList.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
