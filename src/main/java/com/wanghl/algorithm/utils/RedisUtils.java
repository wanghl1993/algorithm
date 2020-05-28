package com.wanghl.algorithm.utils;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author
 */
public class RedisUtils {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("connected to server successfully");
        System.out.println("查看服务是否运行" + jedis.ping());

        jedis.set("w3ckey","Redis tutorial");
        //获取存储的数据并输出
        System.out.println(jedis.get("w3ckey"));
        System.out.println("wanghl" + jedis.get("shiro:session:80ef5d44-f6bf-4433-ac4e-b0b504baf367"));

        jedis.lpush("tutorial-list","Redis");
        jedis.lpush("tutorial-list","Mongodb");
        jedis.lpush("tutorial-list","Mysql");

        //循环输出
        List<String> list = jedis.lrange("tutorial-list",0,5);
        for(int i = 0; i < list.size(); i++){
            System.out.println("Stored string in redis:: "+list.get(i));
        }

        Set<String> list1 = jedis.keys("*");
        System.out.println(list1.toArray());
//        for(int i = 0; i < list1.size(); i++){
//            System.out.println("set==》" + list1.toArray());
//        }

    }

}
