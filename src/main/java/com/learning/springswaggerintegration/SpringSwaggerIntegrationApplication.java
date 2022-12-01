package com.learning.springswaggerintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringSwaggerIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSwaggerIntegrationApplication.class, args);
	}


	/*
	* Docket is used for controlling the default behaviour of Swagger in generating the documentation.
	* As you don't want to show all default details which swagger picks automatically from your Service.
	* Below are some ways of restricting swagger lookup areas to pick for documentation
	*
	* ApiInfo():- Is a way of manipulating the header of the documentation which otherwise
	* contains lot of unnecessary information
	* */
	@Bean
	public Docket getSwaggerConf(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/contacts/*"))
				.apis(RequestHandlerSelectors.basePackage("com.learning"))
				.build()
				.apiInfo(new ApiInfo("Spring-Swagger Demo",
						"Spring-Swagger Step by Step Learning",
						"1.0.0",
						"",
						new springfox.documentation.service.Contact("PV", "", "PV@gmail.com"),
						"",
						"",
						Collections.emptyList()));

	}
}
