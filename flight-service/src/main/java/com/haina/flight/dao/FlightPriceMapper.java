package com.haina.flight.dao;

import com.haina.flight.model.FlightPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlightPriceMapper {

        List<FlightPrice> selectByODAndDepartDate(@Param("origin") String origin,
                                                  @Param("dest")  String dest,
                                                  @Param("departDate") String departDate);
}