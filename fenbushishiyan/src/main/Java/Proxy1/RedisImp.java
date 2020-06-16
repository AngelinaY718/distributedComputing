package Proxy1;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisImp implements Redis{
    private static String url="39.101.217.212";
    private Jedis jedis;
    @Override
    public boolean pay(int price) {

        jedis = new Jedis(url, 6379);
        System.out.println(jedis.ping());

        int moneyTmp = Integer.parseInt(jedis.get("money"));
        if (moneyTmp > price){
            moneyTmp=moneyTmp-price;
            jedis.set("money", String.valueOf(moneyTmp));
            System.out.println(jedis.get("money"));
            jedis.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean saveInfo(String name, String phone) {
        jedis = new Jedis(url, 6379);
        System.out.println(jedis.ping());
        if(name!=null&&phone!=null){
            jedis.set("name",name);
            jedis.set("phone",phone);
            jedis.expire("name", 1800);
            jedis.expire("phone", 1800);
            jedis.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeInfo() {
        jedis = new Jedis(url, 6379);
        System.out.println(jedis.ping());
        if(jedis.exists("name")&&jedis.exists("phone")){
            jedis.del("name");
            jedis.del("phone");
            jedis.close();
            return true;
        }
        return false;
    }

    @Override
    public Map<String, String> getInfo() {
        jedis = new Jedis(url, 6379);
        System.out.println(jedis.ping());
        Map<String, String> map=new HashMap<>();
        map.put("name",jedis.get("name"));
        map.put("phone",jedis.get("phone"));
        jedis.close();
        return map;
    }
}
