package br.unesp.agrotech.configurations;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigurattion {

    private static final Set<String> CONTENT_TYPES_SUPPORTED = Set.of(
        MediaType.APPLICATION_JSON_VALUE
    );

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("agrotech")
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.unesp.agrotech"))
            .build()
            .ignoredParameterTypes(LocalDate.class, CompletableFuture.class)
            .directModelSubstitute(LocalDate.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class, Optional.class)
            .tags(resources()[0], resources())
            .consumes(CONTENT_TYPES_SUPPORTED)
            .produces(CONTENT_TYPES_SUPPORTED)
            .apiInfo(metadata());
        }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
            .title("SOO - Ciências da Computação - UNESP ")
            .description("Descrição API.")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .build();
    }

    private Tag[] resources() {
        return new Tag[] {
            new Tag("Estante", "Este endpoint oferece serviços em relação a estantes em uma base de dados relacional."),
        };
    }
}
