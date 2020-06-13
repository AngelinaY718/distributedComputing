package com.yky.entity;

import java.io.Serializable;
import java.sql.Connection;

public class Card implements Serializable {
    public String cardid;
    public String password;
    public int money;
    public int identifyer;
    public int wrong;

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getIdentifyer() {
        return identifyer;
    }

    public void setIdentifyer(int identifyer) {
        this.identifyer = identifyer;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }
}
