package com.anz.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * ANZ Engineering: Swagger configuration class(with minimal configuration) will
 * enable the user to view/execute all/ specific REST end points used in the
 * application through GUI specific implementation.
 * 
 * Note: For example, user can view all the end points with the localhost url:
 * http://localhost:8080/swagger-ui.html once application built and started
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@Configuration
@EnableSwagger2
public class AnzBankSwaggerConfig {

	/**
	 * ANZ Engineering: Docket which will Configures API operations (via regex
	 * patterns) required for the application.
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	/**
	 * ANZ Engineering: Method is responsible to set API end point(s) root path.
	 * 
	 * @return Predicate<String>
	 */
	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/anz.*"));
	}

	/**
	 * ANZ Engineering: Configure the application related information such as title,
	 * description, contact, license etc.
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ANZ Engineering API")
				.description("ANZ Engineering: API reference documentation")
				.termsOfServiceUrl("http://www.xyz.com/testUrl")
				.contact(new Contact("Bijoy Baral", "http://www.xyz.com/testUrl", "bijoy.on.java@gmail.com"))
				.license("Test ANZ Engineering License").licenseUrl("bijoy.on.java@gmail.com").version("1.0").build();
	}

}
