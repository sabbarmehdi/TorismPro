package com.tourism.app.repository;


import com.tourism.app.model.TripGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TripGuideListRepo extends JpaRepository<TripGuide, Long> {
    @Query("select t from TripGuide t where UPPER(t.tripName) like concat('%', upper(?1),'%')")
    List<TripGuide> findTripsGuideByName(String tripName);
}
