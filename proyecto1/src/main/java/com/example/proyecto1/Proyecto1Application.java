package com.example.proyecto1;

import com.example.proyecto1.model.Server;
import com.example.proyecto1.repository.ServerRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static com.example.proyecto1.enums.Status.SERVER_UP;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Server API", version = "1.0", description = "Informacion de los servidores"))
public class Proyecto1Application {

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

 /*   @Bean
    CommandLineRunner run(ServerRepository serverRepository){
        return args -> {
            serverRepository.save(new Server(null,"192.168.1.160","ubuntu Linux", "16 GB","Personal PC","s", SERVER_UP));
        };
    }*/

    @Bean
    public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList(
                "Origin", "Access-Control-Allow-Origin",
                "Content-Type", "Accept",
                "Jwt-Token", "Authorization",
                "Origin", "Accept",
                "X-Requested-With", "Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type",
                    "Accept", "Jwt-Token",
                    "Authorization", "Access-Control-Allow-Origin",
                    "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials",
                    "Filename"));
            corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
            urlBasedCorsConfigurationSource.registerCorsConfiguration( "/**", corsConfiguration);
     return new CorsFilter(urlBasedCorsConfigurationSource);
    }




    /*revisar video https://www.youtube.com/watch?v=8ZPsZBcue50*/

}
