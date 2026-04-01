package io.github.mattheusffalbuquerque.duma.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME = "bearerAuth";

    @Bean
    public OpenAPI dumaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Duma API")
                        .version("v1")
                        .contact(new Contact().name("Duma Support")
                                .email("contato@duma.com"))
                        .description("API documentation for the Duma application"))
                        .components(new Components()
                                .addSecuritySchemes(SECURITY_SCHEME, 
                               new SecurityScheme()
                                       .type(SecurityScheme.Type.HTTP)
                                       .scheme("bearer")
                                       .bearerFormat("JWT")
                                       .name(SECURITY_SCHEME)
                               )).addSecurityItem(
                                new SecurityRequirement().addList(SECURITY_SCHEME)

                );
    }

}
