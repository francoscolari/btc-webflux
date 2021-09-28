package com.project.wenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = { "com.project.wenance.models" })
public class WenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WenanceApplication.class, args);

	}

}
