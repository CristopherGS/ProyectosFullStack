package com.example.proyecto1.repository;

import com.example.proyecto1.model.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAdress);

}
