package Proxy1;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisImp implements Redis{
    private static String url="39.99.214.110";

    public RedisImp() {
    }

    @Override
    public boolean pay(int price) {

        Jedis jedis = new Jedis(url, 6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());


        String s=jedis.get("money");
        System.out.println("money:"+s);

        int moneyTmp = Integer.parseInt(s);
        if (moneyTmp > price){
            moneyTmp=moneyTmp-price;
            jedis.set("money", String.valueOf(moneyTmp));
            System.out.println(jedis.get("money"));
            jedis.close();
            return true;
        }
        return false;
    }

}
