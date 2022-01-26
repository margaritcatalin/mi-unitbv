package com.carstore.billingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages={"com.carstore.CarStoreModel","com.carstore.billingservice"})
public class CarStoreBillingApplication{

    public static void main(String[] args) {
        SpringApplication.run(CarStoreBillingApplication.class, args);
    }

}

