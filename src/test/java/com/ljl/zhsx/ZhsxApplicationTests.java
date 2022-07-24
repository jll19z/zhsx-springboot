package com.ljl.zhsx;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@SpringBootTest
class ZhsxApplicationTests {

    @Test
    void contextLoads() {
        String orderCode ="";
        for (int i = 0; i < 6; i++) {
            int c = (int) (1 + Math.random() * (10 - 1 + 1));
            orderCode +=c;
        }

        //System.out.println(orderCode);
        String orderNo = "D" + new Date().getTime()+ orderCode;
        System.out.println("订单编号"+orderNo);

    }

}
