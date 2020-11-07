package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Long> {

    Optional<Tourist> findByUsername(String username);
    Optional<Tourist> findByMail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByMail(String email);



    void deleteByMail(String email);
}
