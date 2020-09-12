package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Long> {
}
