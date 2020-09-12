package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.TourGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourGuideRepo extends JpaRepository<TourGuide, Long> {
}
