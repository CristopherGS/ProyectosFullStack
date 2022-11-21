package com.example.proyecto1.service.implementation;

import com.example.proyecto1.enums.Status;
import com.example.proyecto1.model.Server;
import com.example.proyecto1.repository.ServerRepository;
import com.example.proyecto1.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImplementation implements ServerService{
    private final ServerRepository serverrepository;

    @Override
    public Server create(Server server) {
        log.info("Saving new Server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverrepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pingin Server IP:{}", ipAddress);
        Server server = serverrepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverrepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("FETCHING ALL SERVERS");
        return serverrepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Optional<Server> get(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverrepository.findById(id);
        /*return serverrepository.findById(id).get();*/
    }

    @Override
    public Server update(Server server) {
        log.info("updating server: {}", server.getName());
        return serverrepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting server id {}", id);
        serverrepository.deleteById(id);
        return Boolean.TRUE;
    }
    private String setServerImageUrl() {
        return null;
    }
}
