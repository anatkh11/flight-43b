package com.haina.flight.service.impl;

import com.haina.flight.dao.FlightPriceMapper;
import com.haina.flight.model.FlightPrice;
import com.haina.flight.service.ICacheService;
import com.haina.flight.service.IFlightService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FlightServiceImpl implements IFlightService{
    @Resource
    private FlightPriceMapper flightPriceMapper;

    @Resource
    private ICacheService cacheService;
      /*  public FlightPrice dd(){
            //1.从缓存中读取数据
            ICacheService cacheService;
            List<FlightPrice> flighFromCache= cacheService.getFlighFromCache("BJS","BKK","2015-05-20");
            //2.判断缓存中是否有数据
            if(CollectionUtils.isNotEmpty(flightFromCache)){
                System.out.println("read from cache");
                return flighFromCache;
            }
            flighFromCache = flightPriceMapper.selectByODAndDepartDate(origin,dest,departDate);
            if(){
                System.out.println("read from db");
            }
            //3.有数据就直接返回给Controller
            //4.没有数据从数据库中查询
            //5.判断数据的结果是否为空
            //6.不空则输入数据到缓存
        }

        @Resource
        private FlightPriceMapper flightPriceMapper;*/

    @Override
    public List<FlightPrice> getFlight(String origin, String dest, String departDate) {
        //1.从缓存中读取数据
        //2.判断缓存中是否有数据
        //3.有数据就直接返回给controller
        //4.没有数据则从数据库中查询
        //5.判断数据中结果是否为空
        //6.不空则插入数据到缓存
        List<FlightPrice> flightFromCache = cacheService.getFlighFromCache(
                origin, dest, departDate);
        if(CollectionUtils.isNotEmpty(flightFromCache)){
            System.out.println("read from cache");
            return flightFromCache;
        }
        flightFromCache = flightPriceMapper.selectByODAndDepartDate(origin, dest, departDate);
        if(CollectionUtils.isNotEmpty(flightFromCache)){
            System.out.println("read from db, and update cache");
            cacheService.cacheFlight(origin, dest, departDate, flightFromCache);
        }

        return flightFromCache;
    }

}
