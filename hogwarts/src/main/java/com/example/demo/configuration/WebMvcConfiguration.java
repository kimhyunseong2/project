package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 파일 경로를 웹에서 서빙할 수 있도록 설정
		registry.addResourceHandler("/uploads/**")
				.addResourceLocations("file:/C:/Users/DU/project/hogwarts/uploads/");
	}
}
