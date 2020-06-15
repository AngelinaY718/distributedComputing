package com.yky.iml;

import redis.clients.jedis.Jedis;

public class PaymentImp implements Payment{
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
            return true;
        }
        return false;
    }
}
