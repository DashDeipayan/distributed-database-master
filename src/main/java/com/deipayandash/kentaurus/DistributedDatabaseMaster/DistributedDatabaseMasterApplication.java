package com.deipayandash.kentaurus.DistributedDatabaseMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DistributedDatabaseMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedDatabaseMasterApplication.class, args);
	}

}