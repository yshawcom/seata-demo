package com.yshaw.seata.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xdl
 * @date 2021-04-20
 */
@SpringCloudApplication
@EnableFeignClients
public class SeataDemoBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataDemoBusinessApplication.class, args);
    }

}
