package com.example.experience_platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@MapperScan("com.example.experience_platform.board.mapper")
@MapperScan("com.example.experience_platform.user.mapper")
@MapperScan("com.example.experience_platform.campaign.mapper")
@MapperScan("com.example.experience_platform.file.mapper")
public class ExperiencePlatformApplication {
	public static void main(String[] args) {
		System.out.println("🔥🔥🔥 ExperiencePlatformApplication main() 실행됨!");
		SpringApplication.run(ExperiencePlatformApplication.class, args);
	}
}