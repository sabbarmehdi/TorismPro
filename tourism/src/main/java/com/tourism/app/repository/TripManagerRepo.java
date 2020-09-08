package com.tourism.app.repository;

import com.tourism.app.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripManagerRepo extends JpaRepository<Trip, Long> {

}
