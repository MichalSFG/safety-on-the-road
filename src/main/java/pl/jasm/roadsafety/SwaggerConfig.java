package pl.jasm.roadsafety;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Hero API")
                .description("Description hero api")
                .version("2.0.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("pl.jasm.roadsafety"))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    @Bean
    PageableParameterBuilderPlugin pageableParameterBuilderPlugin(TypeResolver resolver) {
        return new PageableParameterBuilderPlugin(resolver);
    }
}
