package com.haina.flight.controller;

import com.haina.flight.constants.FlightConstants;
import com.haina.flight.model.Flight;
import com.haina.flight.model.FlightPrice;
import com.haina.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class TestController {
        //该注解从配置文件中读取配置，{}内的东西与配置文件中一致
        @Value("${app-username}")
        private String name;
        @Resource
        private IFlightService flightService;

        @RequestMapping("test")
        public String test(){
            return name;
        }
        @RequestMapping("getFlight")
        public List<FlightPrice> getFlight(){
             List<FlightPrice> list = flightService.getFlight("BJS","BKK","2019-05-20");

               Map<String,List<FlightPrice>> map = new HashMap<>();
                /*List<Integer> l = new ArrayList<Integer>();
                for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                }*/
               /* list.stream().map(str -> "航司".equals(str)).forEach(System.out::println);*/

               for(FlightPrice flightPrice:list){
                       List<FlightPrice> tmp = map.get(flightPrice.getCarrier());
                       if(tmp == null){
                               tmp = new ArrayList<>();
                       }
                       tmp.add(flightPrice);
                       map.put(flightPrice.getCarrier(),tmp);
               }
                map = list.stream().collect(Collectors.groupingBy(FlightPrice::getCarrier));
                System.out.println(map);



             return list;

        }
        @RequestMapping("getConfig")
        public String getConfig(){
            return FlightConstants.test43b +","+FlightConstants.flightSwitch+","+ FlightConstants.count;
        }
}
