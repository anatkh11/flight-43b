package com.haina.flight.service;

import com.haina.flight.model.FlightPrice;

import java.util.List;

public interface ICacheService {
        /*
        通过出发到达出发时间，从缓存中读取数据
         */
        List<FlightPrice> getFlighFromCache(String origin,String dest,String departDate);

    /**
     * 添加数据到缓存
     * @param origin
     * @param dest
     * @param departDate
     * @param list
     */
        void cacheFlight(String origin,String dest,String departDate,List<FlightPrice> list);

}
