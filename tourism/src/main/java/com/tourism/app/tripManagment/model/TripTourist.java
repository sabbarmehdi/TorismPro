package com.tourism.app.tripManagment.model;

import com.tourism.app.clientManagment.model.Client;

import javax.persistence.Entity;

@Entity(name = "trip_tourist")
public class TripTourist extends Trip {
    public TripTourist() {
    }

    public TripTourist(Long id, String tripName, String description, Trajectory trajectory, int tripPeriod, String startingCity, Long clientId) {
        super(id, tripName, description, trajectory, tripPeriod, startingCity, clientId);
    }


}
