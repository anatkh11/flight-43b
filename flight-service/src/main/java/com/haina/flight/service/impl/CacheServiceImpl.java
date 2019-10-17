package com.haina.flight.service.impl;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.haina.flight.model.Flight;
import com.haina.flight.model.FlightPrice;
import com.haina.flight.service.ICacheService;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.mapping.Join;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class CacheServiceImpl implements ICacheService {
    @Resource
    private RedisTemplate<String,List<FlightPrice>> redisTemplate;

    private Cache<String,List<FlightPrice>> localcache = CacheBuilder.newBuilder()
            .concurrencyLevel(10)
            .expireAfterWrite(20, TimeUnit.SECONDS)
            .maximumSize(10)
            .build();

    @Override
    public List<FlightPrice> getFlighFromCache(String origin, String dest, String departDate) {

        String key = getKey(origin,dest,departDate);


        List<FlightPrice> list = localcache.getIfPresent(key);
        if(CollectionUtils.isNotEmpty(list)){
            System.out.println("read from local");
            return list;
        }
        List<FlightPrice> redis = redisTemplate.opsForValue().get(key);
        if(CollectionUtils.isNotEmpty(redis)){
            System.out.println("read from redis,and update local");
            localcache.put(key,redis);
        }
        return redis;
    }

    @Override
    public void cacheFlight(String origin, String dest, String departDate, List<FlightPrice> list) {
        String key = getKey(origin,dest,departDate);
        redisTemplate.opsForValue().set(key,list);
    }
    //BJS-BKK-2015-05-20
    private String getKey(String origin, String dest, String departDate){

            return Joiner.on("-").join(origin,dest,departDate);
    }
}
