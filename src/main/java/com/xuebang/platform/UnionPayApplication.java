package com.xuebang.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UnionPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnionPayApplication.class, args);
	}
}
