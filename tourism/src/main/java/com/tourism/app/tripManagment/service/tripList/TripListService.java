package com.tourism.app.tripManagment.service.tripList;

import com.tourism.app.tripManagment.model.TripGuide;
import com.tourism.app.tripManagment.model.TripTourist;

import java.util.List;

public interface TripListService {
    List<TripTourist> retrieveTrips();
    List<TripTourist> retrieveTripsByName(String tripName);
    TripTourist retrieveTripById(Long id);

    List<TripTourist> retrieveTripsByClient(Long clientId);
    //List<Trip> retrieveTripsByStartCity();
}
