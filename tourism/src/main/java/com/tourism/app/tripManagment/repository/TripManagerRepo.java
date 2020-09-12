package com.tourism.app.tripManagment.repository;

import com.tourism.app.tripManagment.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripManagerRepo extends JpaRepository<Trip, Long> {

}
