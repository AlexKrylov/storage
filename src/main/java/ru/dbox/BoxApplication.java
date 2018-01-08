package ru.dbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ComponentScan
public class BoxApplication {
	public static void main(String[] args) {
		SpringApplication.run(BoxApplication.class, args);
	}
}
