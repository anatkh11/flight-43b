package com.haina.flight.cotroller;

import com.haina.flight.Service.FeignFlightService;
import com.haina.flight.model.Flight;
import com.haina.flight.request.FlightRequest;
import com.haina.flight.response.FlightResult;
import feign.Feign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset-UTF-8")
public class ApiController {
        @Resource
        private FeignFlightService feignflightservice;
        @RequestMapping("getFlight")
        public FlightResult getFlight(String origin, String dest, String departDate){

            FlightRequest request = new FlightRequest();
            request.setOrigin(origin);
            request.setDest(dest);
            request.setDepartDate(departDate);
           List<Flight> list = feignflightservice.getFlightByODAndDepartdate(request);
           if(list==null){
               FlightResult.fail();
           }

            return FlightResult.success(list);
        }

}
