package com.vadantu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class EcommerceCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceCartApplication.class, args);
    }
}