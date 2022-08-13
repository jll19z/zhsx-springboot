package com.ljl.zhsx;

import com.ljl.zhsx.utils.RSAUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ljl.zhsx.mapper")
public class ZhsxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhsxApplication.class, args);
        RSAUtil.initKey();
    }

}
