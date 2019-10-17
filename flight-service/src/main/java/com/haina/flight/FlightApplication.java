package com.haina.flight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.haina.flight.dao")
@SpringBootApplication
class FlightApplication {

    public static void main(String[] args) {
            //idea创建main方法的快捷方式是psvm然后回车
            SpringApplication.run(FlightApplication.class);
    }
}
