package com.tourism.app.tripManagment.model;

import javax.persistence.Entity;

@Entity(name = "trip_tourist")
public class TripTourist extends Trip {
    public TripTourist() {
    }

    public TripTourist(long id, String tripName, String description, Trajectory trajectory) {
        super(id, tripName, description, trajectory);
    }
}
