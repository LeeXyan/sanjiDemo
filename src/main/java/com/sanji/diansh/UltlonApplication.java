package com.sanji.diansh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//@EnableAutoConfiguration
public class UltlonApplication {

	
  /*  @RequestMapping(value="/")
    public String hello1() {
	    return "Hello World!";
	}*/
    public static void main(String[] args) {
        SpringApplication.run(UltlonApplication.class, args);
    }
}
