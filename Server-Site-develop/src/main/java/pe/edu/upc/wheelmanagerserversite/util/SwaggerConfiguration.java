package pe.edu.upc.wheelmanagerserversite.util;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean(name = "wheel_managerOpenApi")
    public OpenAPI wheel_managerOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("wheel_manager API")
                        .description(
                                "wheel_manager API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0"));

    }
}
