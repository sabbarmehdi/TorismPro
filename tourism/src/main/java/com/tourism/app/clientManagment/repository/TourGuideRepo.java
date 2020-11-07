package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.TourGuide;
import com.tourism.app.clientManagment.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourGuideRepo extends JpaRepository<TourGuide, Long> {


    Optional<TourGuide> findById(String id);

    Optional<TourGuide> findByMail(String mail);
    Optional<TourGuide> findByUsername(String username);

    boolean existsByMail(String email);

    boolean existsByUsername(String username);

    void deleteByMail(String email);
}
