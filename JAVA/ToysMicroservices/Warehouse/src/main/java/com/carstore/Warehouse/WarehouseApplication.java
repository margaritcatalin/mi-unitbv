package com.carstore.Warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages={"com.carstore.CarStoreModel","com.carstore.Warehouse"})
public class WarehouseApplication{

    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }

}

