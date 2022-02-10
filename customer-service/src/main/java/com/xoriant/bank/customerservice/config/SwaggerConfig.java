package com.xoriant.bank.customerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket getDocket() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("customer-service-crud").select()
				.apis(RequestHandlerSelectors.basePackage("com.xoriant.bank.customerservice.resource"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title("Customer CRUD service")
				.description("Customer CRUD service API Documentation").version("1.0").build();
	}

}