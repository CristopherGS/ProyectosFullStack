package com.example.proyecto1;

import com.example.proyecto1.enums.Status;
import com.example.proyecto1.model.Server;
import com.example.proyecto1.repository.ServerRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.example.proyecto1.enums.Status.SERVER_UP;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Server API", version = "1.0", description = "Informacion de los servidores"))
public class Proyecto1Application {

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepository serverRepository){
        return args -> {
            serverRepository.save(new Server(null,"192.168.1.160","ubuntu Linux", "16 GB","Personal PC","s", SERVER_UP));
        };
    }



    /*revisar video https://www.youtube.com/watch?v=8ZPsZBcue50*/

}
