package JavaBean;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class map {
    static Map<String,Integer> ipMap=new HashMap<>();
    static {
        ipMap.put("12000",1);
        ipMap.put("8280",1);

    }

    //    Integer sum=0;
    Integer  pos = 0;

    public String Random() {
        Map<String,Integer> ipServerMap=new ConcurrentHashMap<>();
        ipServerMap.putAll(ipMap);

        Set<String> ipSet=ipServerMap.keySet();

        //定义一个list放所有server
        ArrayList<String> ipArrayList=new ArrayList<String>();
        ipArrayList.addAll(ipSet);

        //循环随机数
        Random random=new Random();
        //随机数在list数量中取（1-list.size）
        int pos=random.nextInt(ipArrayList.size());
        String ipNameReturn= ipArrayList.get(pos);
        return  ipNameReturn;
    }
}
