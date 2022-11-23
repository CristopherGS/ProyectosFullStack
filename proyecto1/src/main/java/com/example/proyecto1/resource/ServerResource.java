package com.example.proyecto1.resource;

import com.example.proyecto1.model.Response;
import com.example.proyecto1.model.Server;
import com.example.proyecto1.service.implementation.ServerServiceImplementation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
@RouterOperation(path = "/server", operation = @Operation(description = "servidores"))
public class ServerResource {

    private final ServerServiceImplementation serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServer(){
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("Servers", serverService.list(30)))
                        .message("Servers retrived")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("listByIpAdress/{ipAdress}")
    public ResponseEntity<Response> getPing(@PathVariable("ipAdress") String ipAdress) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("Servers", serverService.ping(ipAdress)))
                        .message("Pinging Server")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "image/{fileName}", produces = IMAGE_PNG_VALUE )
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Path.of("C:\\Users\\cgguerra\\Downloads\\Images\\" + fileName));
    }

    @PostMapping("update/")
    public ResponseEntity<Response> updateServer(Server server){
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("Servers", serverService.update(server)))
                        .message("Pinging Server")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("save/")
    public ResponseEntity<Response> saveServer(Server server){
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("Servers", serverService.create(server)))
                        .message("Pinging Server")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
