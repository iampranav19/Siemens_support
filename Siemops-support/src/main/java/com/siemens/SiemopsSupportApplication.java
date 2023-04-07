package com.siemens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SiemopsSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiemopsSupportApplication.class, args);
		System.out.println("+++++++++ Siemops App Up and Running ++++++++++++");
	}

}
