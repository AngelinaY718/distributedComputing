package com.yky.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    String id;
    String password;
    int money;
    int take;
    int lock;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", money=" + money + ", take=" + take + ", lock=" + lock
                + "]";
    }
    public int getLock() {
        return lock;
    }
    public void setLock(int lock) {
        this.lock = lock;
    }
    public int getTake() {
        return take;
    }
    public void setTake(int take) {
        this.take = take;
    }
}
