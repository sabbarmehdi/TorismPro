package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Long> {

    Tourist findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByMail(String email);

    Tourist findByMail(String email);

    void deleteByMail(String email);
}
