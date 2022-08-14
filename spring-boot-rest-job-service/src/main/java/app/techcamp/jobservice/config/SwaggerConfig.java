package app.techcamp.jobservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("elearn-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return regex("/jobs.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TechCamp E-Learn Job Service")
				.description("TechCamp API reference for developers")
				.termsOfServiceUrl("https://techcamp.app")
				.contact("info@techcamp.app").license("TechCamp License")
				.licenseUrl("https://policy.techcamp.app").version("1.0").build();
	}

}
