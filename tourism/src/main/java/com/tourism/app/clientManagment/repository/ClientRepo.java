package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Optional<Client> findById(String id);

    Client findByMail(String mail);
    Client findByUsername(String username);

    boolean existsByMail(String email);

    boolean existsByUsername(String username);

    void deleteByMail(String email);
}
