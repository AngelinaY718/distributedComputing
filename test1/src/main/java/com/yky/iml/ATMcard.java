package com.yky.iml;

import com.yky.entity.Card;

import java.sql.Connection;
import java.sql.SQLException;

public interface ATMcard {
    Card login(String a, String b) throws SQLException;
    String search(Card card) throws SQLException;
    String save(Card card,int a) throws SQLException;
    String draw(Card card,int a) throws SQLException;
    boolean alter(Connection conn,String s) throws SQLException;
    String close();
}
