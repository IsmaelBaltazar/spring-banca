package com.nttdata.banca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.nttdata.banca"})
public class SpringBancaApplication {
	public static void main(String[] args) {
		//Logger log = LoggerFactory.getLogger(SpringBancaApplication.class);
		SpringApplication.run(SpringBancaApplication.class, args);
	}

}
