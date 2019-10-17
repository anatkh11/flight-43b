package com.haina.flight.Service;

import com.haina.flight.model.Flight;
import com.haina.flight.request.FlightRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient("fegin-flight-service")

public interface FeignFlightService {
            @RequestMapping(value = "getFlightByFeign",method = RequestMethod.POST)
            List<Flight>  getFlightByODAndDepartdate(FlightRequest request);


}
