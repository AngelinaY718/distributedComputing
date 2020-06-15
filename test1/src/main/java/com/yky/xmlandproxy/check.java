package com.yky.xmlandproxy;

import com.yky.database.Link;
import com.yky.entity.Card;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class check {

    private Link dataSource = new Link();
    private Connection connection =dataSource.getConnection();

    public check() throws SQLException {
    }

    public void checkIdentifyer(String a,String b) throws SQLException {

        PreparedStatement state =connection.prepareStatement("select wrong from card where cardid=?");
        state.setString(1,a);
        ResultSet result =state.executeQuery();
        int ai=0,bi=0;
        //4、输出查询结果
        while(result.next()){
            ai=result.getInt(1);
        }
        if(ai==3){
            String sql="update card set identifyer = 1 where cardid='"+a+"'";
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("密码连续三次输入错误，账户已锁定");
            statement.close();
        }
        result.close();
        state.close();
        dataSource.releaseConnection(connection);
    }

    public void logger(Card card,int a) throws SQLException {
        int aa=0;
        Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        aa= card.getMoney()-a;
        PreparedStatement state =connection.prepareStatement("insert into looger(cardid,time,drawmoney,before,after) values(?,?,?,?,?)");
        state.setString(1,card.getCardid());
        state.setString(2,dateNowStr);
        state.setInt(3,a);
        state.setInt(4,card.getMoney());
        state.setInt(5,aa);
        int result =state.executeUpdate();
        if(result==1){
            state.close();
            dataSource.releaseConnection(connection);
        }
    }

}
