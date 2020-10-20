package com.microservices.exams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({"com.course.entity"})
@EnableEurekaClient
@SpringBootApplication
public class BackendMicroservicesExamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendMicroservicesExamsApplication.class, args);
	}

}
