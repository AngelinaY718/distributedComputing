package JavaBean;

import java.io.Serializable;

public class User{
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
}
