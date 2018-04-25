package com.bynow.rei.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bynow.rei"})
public class ReiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReiRestApplication.class, args);
    }
}
