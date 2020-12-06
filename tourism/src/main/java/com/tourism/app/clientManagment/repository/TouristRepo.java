package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Long> {

    Optional<Tourist> findByUsername(String username);
    Boolean existsByUsername(String username);

    @Query("select to from tourist to where to.id=:id" )
    Tourist findTouristById(Long id);

    Optional<Tourist> findById(Long id);
}
