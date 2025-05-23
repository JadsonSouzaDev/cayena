package br.com.cayena.order.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cayena Order API")
                        .version("1.0")
                        .description("This API provides endpoints for managing orders in the Cayena system.")
                        .contact(new Contact()
                                .name("Cayena Development Team")
                                .email("dev@cayena.com.br")));
    }
} 