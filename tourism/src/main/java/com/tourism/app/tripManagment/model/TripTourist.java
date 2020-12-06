package com.tourism.app.tripManagment.model;

import com.tourism.app.clientManagment.model.Client;

import javax.persistence.Entity;

@Entity(name = "trip_tourist")
public class TripTourist extends Trip {
    public TripTourist() {
    }

    public TripTourist(java.lang.Long id, String tripName, String description, Trajectory trajectory, Long client) {
        super(id, tripName, description, trajectory, client);
    }
}
