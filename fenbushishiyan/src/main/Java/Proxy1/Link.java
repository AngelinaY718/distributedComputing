package Proxy1;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Link{
    static ComboPooledDataSource dataSource=new ComboPooledDataSource();
    //从连接池中取用一个连接
    public static Connection getConnection(){

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //释放连接回连接池
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
