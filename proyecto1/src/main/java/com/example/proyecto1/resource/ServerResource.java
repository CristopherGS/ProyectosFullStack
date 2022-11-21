package com.example.proyecto1.resource;

import com.example.proyecto1.model.Response;
import com.example.proyecto1.service.implementation.ServerServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {

    private final ServerServiceImplementation serverService;

    @GetMapping("list")
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
    public ResponseEntity<Response> getServer(@PathVariable("ipAdress") String ipAdress) throws IOException {
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


}
