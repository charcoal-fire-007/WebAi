package com.tlias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TliasWebAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebAiApplication.class, args);
    }

}
