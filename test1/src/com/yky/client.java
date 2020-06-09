package com.yky;

import com.yky.entity.Card;
import com.yky.entity.map;
import com.yky.iml.ATMcard;
import com.yky.iml.Atm;
import com.yky.xmlandproxy.ProxyHandler1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws SQLException {
	// write your code here
        map map=new map();
        int port= Integer.parseInt(map.Random());
        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        //ATMcard atm= proxyHandler1.getProxy(ATMcard.class,"127.0.0.1",8280);
        ATMcard atm= proxyHandler1.getProxy(ATMcard.class,"127.0.0.1",port);
        if(atm==null){
            System.out.println(1);
        }
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("      欢迎使用ATM系统");
        System.out.println("          请登录");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("账号");
        Scanner input=new Scanner(System.in);
        String a=input.next();
        System.out.println("密码");
        String b=input.next();
        Card card=atm.login(a,b);
        boolean boo=false;
        if(card.getCardid()!=null){
            boo=true;
        }
        while (boo){
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("        请选择操作");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("1.查询");
            System.out.println("2.存钱");
            System.out.println("3.取钱");
            System.out.println("4.退出");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            int ch=input.nextInt();
            int chh;
            String s;
            switch (ch){
                case 1: {
                    s = atm.search(card);
                    System.out.println(s);
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
                    s=atm.save(card,save);
                    System.out.println(s);
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
                    s=atm.draw(card,draw);
                    System.out.println(s);
                    System.out.println("是否返回主页面？[Y]1/[N]0");
                    chh=input.nextInt();
                    if(chh!=1){
                        boo=false;
                    }
                    break;
                case 4:
                    boo=false;
                    System.out.println(atm.close());
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
