package com.recruitment.api;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRecruitmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRecruitmentApplication.class, args);
	}
	@PostConstruct
	private void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
