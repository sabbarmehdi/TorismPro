package com.tourism.app.service.tripList;

import com.tourism.app.model.Trip;

import java.util.List;

public interface TripListService {
    List<Trip> retrieveTrips();
    List<Trip> retrieveTripsByName(String tripName);
    //List<Trip> retrieveTripsByStartCity();
}
