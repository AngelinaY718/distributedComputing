package com.yky.entity;

import java.io.Serializable;

public class response implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;

    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
