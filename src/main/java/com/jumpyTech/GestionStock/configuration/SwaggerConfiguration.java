package com.jumpyTech.GestionStock.configuration;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration

public class SwaggerConfiguration {
	
	private static final String APP_ROOT = "gestiondestock/v1/";

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new ApiInfoBuilder()
						.description("Gestion de Stock Api Documentation")
						.title("Gestion de Stock Rest API ")
						.build()
						)
				.groupName("REST API V&")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jumpyTech.GestionStock"))
				.paths(PathSelectors.ant(APP_ROOT+"/**"))
				.build();
	}

}
