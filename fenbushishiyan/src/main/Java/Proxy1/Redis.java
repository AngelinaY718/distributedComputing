package Proxy1;

import java.util.ArrayList;
import java.util.Map;

public interface Redis {
    public boolean pay(int price);
    public boolean saveInfo(String name,String phone);
    public boolean removeInfo();
    public Map<String,String> getInfo();
}
