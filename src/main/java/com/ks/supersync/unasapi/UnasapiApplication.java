package com.ks.supersync.unasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@SpringBootApplication
public class UnasapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnasapiApplication.class, args);
	}

}
