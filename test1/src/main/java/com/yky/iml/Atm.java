package com.yky.iml;

import com.yky.entity.Card;
import com.yky.database.Link;

import java.sql.*;
import java.util.Scanner;

public class Atm implements ATMcard {

    public Card card=new Card();
    private Link dataSource = new Link();
    private Connection connection=dataSource.getConnection();

    public Atm() throws SQLException {
    }

    @Override
    public Card login(String a,String b) throws SQLException {
        PreparedStatement state =connection.prepareStatement("select * from card where cardid=?");
        state.setString(1,a);
        //3、查询数据库并返回结果
        ResultSet result =state.executeQuery();
        String aa = null,bb = null;
        int ai=0,bi=0,ci=0;
        //4、输出查询结果
        while(result.next()){
            aa=result.getString(1);
            bb=result.getString(2);
            ai=result.getInt(3);
            bi=result.getInt(4);
            ci=result.getInt(5);
        }
        if(a.equals(aa) &&b.equals(bb)&&bi==0){
            System.out.println("登陆成功");
            card.setCardid(aa);
            card.setPassword(bb);
            card.setMoney(ai);
            card.setIdentifyer(bi);
            card.setWrong(0);
            String sql="update card set wrong="+card.getWrong()+" where cardid='"+aa+"'";
            alter(connection,sql);
        }
        else if(bi==1){
            System.out.println("账号被锁定，无法使用");
        }
        else if(b!=bb){
            ci=ci+1;
            int cc=3-ci;
            String sql="update card set wrong="+ci+" where cardid='"+aa+"'";
            alter(connection,sql);
            System.out.println("输入错误！您还有"+cc+"次机会输入密码！");
        }
        result.close();
        state.close();
        return card;
    }

    @Override
    public String search(Card card) throws SQLException {
        int ch;
        Scanner input = new Scanner(System.in);
        String s="您的账户信息如下：卡号："+card.getCardid()+"余额:"+card.getMoney();
        return s;
    }

    @Override
    public String save(Card card,int save) throws SQLException {

        int balance;
        balance=card.getMoney();
        balance=balance+save;
        String sql="update card set money="+balance+" where cardid='"+card.getCardid()+"'";
        String s;
        if(alter(connection, sql)){
            card.setMoney(balance);
            s="存款成功!您的账户信息如下：卡号："+card.getCardid()+"余额:"+card.getMoney();
        }
        else{
            s="存款失败!您的账户信息如下：卡号："+card.getCardid()+"余额:"+card.getMoney();
        }
        return s;
    }

    @Override
    public String draw(Card card,int draw) throws SQLException {
        int balance;
        balance=card.getMoney();
        String s;
        if(balance>draw){
            balance=balance-draw;
            String sql="update card set money="+balance+" where cardid='"+card.getCardid()+"'";
            if(alter(connection, sql)){
                card.setMoney(balance);
                s="取款成功!您的账户信息如下：卡号："+card.getCardid()+"余额:"+card.getMoney();
            }
            else{
                s="取款失败!您的账户信息如下：卡号："+card.getCardid()+"余额:"+card.getMoney();
            }
        }
        else{
            s="取款超出金额！";
        }
        return s;
    }

    @Override
    public boolean alter(Connection conn, String s) throws SQLException {
        boolean b=false;
        Statement statement=conn.createStatement();
        int rs=statement.executeUpdate(s);
        if(rs==1){
            b=true;
        }
        return b;
    }

    @Override
    public String close() {
        dataSource.releaseConnection(connection);
        String s="感谢使用本系统，欢迎下次使用";
        return s;
    }


}
