package com.haina.flight;

import com.haina.flight.dao.FlightPriceMapper;
import com.haina.flight.model.FlightPrice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={FlightApplication.class})
public class MysqlTest {
        @Resource
        private FlightPriceMapper flightPriceMapper;
        @Test
        public void test(){
                List<FlightPrice> list = flightPriceMapper.selectByODAndDepartDate(
                        "BJS",
                        "BKK",
                        "2019-05-20");
            System.out.println(list);


        }
}
