package com.gmh.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author yichuan
 */
@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.gmh.order.mapper"})
public class OrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }
}