package com.sadatspringbootcourse.socialmedia.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Social media app",
                description = "sample app for spring boot course",
                termsOfService=" terms Of Service",
                version="1.0.0"
        ),
        servers= {
                @Server(
                        url = "http://localhost:8081/"
                ),
                @Server(
                        url = "http://localhost:9090/"
                )
        }
)
public class SwaggerConfig {
}
