package com.haina.flight;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={FlightApplication.class})
public class RedisTest {
        @Resource
        private RedisTemplate<String , String> redisTemplate;
        @Test
        public void testString(){
               // redisTemplate.opsForValue().set("abc","123",10, TimeUnit.SECONDS);
               /* redisTemplate.opsForValue().append("abc123","qwer");
                redisTemplate.opsForValue().append("abc123","hjkl");*/
              /*  String abc = redisTemplate.opsForValue().get("abc123");
                String andset = redisTemplate.opsForValue().getAndSet("abc123","change");
            System.out.println(andset);
                String abc123 = redisTemplate.opsForValue().get("abc123");
            System.out.println(abc123);*/
            /*long abc123 =  redisTemplate.opsForValue().size("abc123");
            System.out.println(abc123);*/
           /* Map<String , String> map = new HashMap<>() ;
            map.put("abc234","1");
            map.put("abc456","2");
            redisTemplate.opsForValue().multiSet(map);*/
            /*List<String> list = new ArrayList<>();
            list.add("abc123");
            list.add("abc456");
            list.add("abc345");
            redisTemplate.opsForValue().multiGet(list);
            System.out.println(list);*/
           /* for(int i=0;i<=10;i++){
                long count123 = redisTemplate.opsForValue().increment("count123",-5);
                System.out.println(count123);
            }*/
          /* redisTemplate.opsForList().leftPush("list43b","aaa");*/

          /* String pop1 = redisTemplate.opsForList().leftPop("list43b");*/
           /*long listSize = redisTemplate.opsForList().size("list43b");
            System.out.println(listSize);
            *//*System.out.println(pop1);*//*
           List<String> list43b = redisTemplate.opsForList().range("list43b",0,10);
           System.out.println(list43b);*/
            redisTemplate.opsForHash().put("map43b","k1","v1");
            redisTemplate.opsForHash().put("map43b","k2","v2");
            redisTemplate.opsForHash().put("map43b","k3","v3");
            redisTemplate.opsForHash().put("map43b","k4","v4");
            redisTemplate.opsForHash().put("map43b","k5","v5");
            redisTemplate.opsForHash().put("map43b","k6","v6");
            redisTemplate.opsForHash().put("map43b","k7","v7");
            redisTemplate.opsForHash().put("map43b","k8","v8");
            /*Set<Object> map43b = redisTemplate.opsForHash().keys("map43b");*/
            List<Object> map43b1 = redisTemplate.opsForHash().values("map43b");
            System.out.println(map43b1);
           /* System.out.println(map43b);*/
            /*Object o = redisTemplate.opsForHash().get("map43b","k1");*/
           /* System.out.println(o);*/
        }

}
