package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.TourGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourGuideRepo extends JpaRepository<TourGuide, Long> {


    Optional<TourGuide> findById(Long id);

    Optional<TourGuide> findByUsername(String username);

    boolean existsByUsername(String username);

}
