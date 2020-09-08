package com.tourism.app.service.tripList;

import com.tourism.app.model.TripTourist;

import java.util.List;

public interface TripListService {
    List<TripTourist> retrieveTrips();
    List<TripTourist> retrieveTripsByName(String tripName);
    //List<Trip> retrieveTripsByStartCity();
}
