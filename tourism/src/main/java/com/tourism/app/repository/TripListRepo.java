package com.tourism.app.repository;

import com.tourism.app.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@NoRepositoryBean
public interface TripListRepo<TripGuide extends Trip> extends JpaRepository<Trip, Long> {
    @Query("select t from Trip t where UPPER(t.tripName) like concat('%', upper(?1),'%')")
    List<Trip> findTripsByName(String tripName);
}
