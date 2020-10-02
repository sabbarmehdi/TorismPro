package com.tourism.app.tripManagment.model;

import com.tourism.app.clientManagment.model.Client;

import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "trip_tourist")
public class TripTourist extends Trip {
    public TripTourist() {
    }

    public TripTourist(long id, String tripName, String description, Trajectory trajectory, Set<Client> clients) {
        super(id, tripName, description, trajectory, clients);
    }

}
