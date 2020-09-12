package com.tourism.app.tripManagment.service.tripList;

import com.tourism.app.tripManagment.model.TripTourist;

import java.util.List;

public interface TripListService {
    List<TripTourist> retrieveTrips();
    List<TripTourist> retrieveTripsByName(String tripName);
    //List<Trip> retrieveTripsByStartCity();
}
