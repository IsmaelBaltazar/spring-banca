package com.nttdata.banca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.nttdata.banca"})
public class SpringBancaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBancaApplication.class, args);
	}

}
