package com.yky;


import com.yky.entity.Flight;
import com.yky.entity.User;
import com.yky.entity.map;
import com.yky.iml.ATMcard;
import com.yky.iml.Atm;
import com.yky.iml.FlightService;
import com.yky.iml.FlightServiceImp;
import com.yky.xmlandproxy.ProxyHandler1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class client {

    private static SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws SQLException {
	// write your code here

        map map=new map();
        int port= Integer.parseInt(map.Random());
        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        //ATMcard atm= proxyHandler1.getProxy(ATMcard.class,"127.0.0.1",8280);
        //ATMcard atm= proxyHandler1.getProxy(ATMcard.class,"127.0.0.1",port);
        //FlightService flight = proxyHandler1.getProxy(FlightService.class,"127.0.0.1",port);
        FlightService flight = new FlightServiceImp();
        if(flight==null){
            System.out.println(1);
        }
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("      欢迎使用机票系统");
        System.out.println("          请登录");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("账号");
        Scanner input=new Scanner(System.in);
        String a=input.next();
        System.out.println("密码");
        String b=input.next();
        User user= flight.login(a,b);
        boolean boo=false;
        if(user!=null){
            boo=true;
        }
        while (boo){
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("        请选择操作");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("1.查询航班");
            System.out.println("2.下订单");
            System.out.println("3.查订单");
            System.out.println("4.退出");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            int ch=input.nextInt();
            int chh;
            String s;
            switch (ch){
                case 1: {
                    Flight searchflight=new Flight();
                    System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println("请输入出发地：");
                    String depart=input.next();
                    System.out.println("请输入目的地：");
                    String arrive=input.next();
                    System.out.println("请输入日期xxxx-xx-xx：");
                    String datein=input.next();
                    Date date=null;
                    try {
                        date = sf.parse(datein);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    searchflight.setTicketDepart(depart);
                    searchflight.setTicketArrive(arrive);
                    searchflight.setTicketDate(sqlDate);

                    List<Flight> flightList = flight.searchFlight(searchflight);
                    for(Flight fl : flightList) {
                        System.out.println(fl);
                    }
                    System.out.println("是否返回主页面？[Y]1/[N]0");
                    chh = input.nextInt();
                    if (chh != 1) {
                        boo = false;
                    }
                    break;
                }
                case 2: {
                    int save;
                    System.out.println("请输入存款金额：");
                    save=input.nextInt();
                    System.out.println("是否返回主页面？[Y]1/[N]0");
                    chh = input.nextInt();
                    if (chh != 1) {
                        boo = false;
                    }
                    break;
                }
                case 3:
                    int draw;
                    System.out.println("请输入取款金额：");
                    draw=input.nextInt();
                    System.out.println("是否返回主页面？[Y]1/[N]0");
                    chh=input.nextInt();
                    if(chh!=1){
                        boo=false;
                    }
                    break;
                case 4:
                    boo=false;
                    break;
                default:
                {
                    System.out.println("无效输入请重新选择");
                    break;
                }
            }
        }
    }
}
