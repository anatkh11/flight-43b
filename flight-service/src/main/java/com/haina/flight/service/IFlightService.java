package com.haina.flight.service;

import com.haina.flight.model.FlightPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFlightService {
            //根据出发-到达-出发时间 查询航班列表

             List<FlightPrice> getFlight(String origin,String dest,String departDate);

}
