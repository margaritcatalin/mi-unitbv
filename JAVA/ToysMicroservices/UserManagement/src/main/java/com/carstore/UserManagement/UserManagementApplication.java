package com.carstore.UserManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages={"com.carstore.CarStoreModel","com.carstore.UserManagement"})
public class UserManagementApplication{

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

}

