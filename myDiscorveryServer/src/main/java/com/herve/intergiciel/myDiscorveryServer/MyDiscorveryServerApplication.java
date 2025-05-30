package com.herve.intergiciel.myDiscorveryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MyDiscorveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDiscorveryServerApplication.class, args);
	}

}
