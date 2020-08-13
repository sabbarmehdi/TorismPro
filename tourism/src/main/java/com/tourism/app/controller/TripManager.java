package com.tourism.app.controller;

import com.tourism.app.model.Trip;

import java.util.ArrayList;

/*
 Controller to manage Trips
 for Tourist and Tour Guide
 */
public class TripManager {
    private ArrayList<Trip> trip;

    public TripManager() {
        trip = new ArrayList<Trip>();
    }

    //add new trip
    public void addTrip(Trip trip){}

    //Update Trip by id
    public void updateTrip(long id){}

    //delete Trip by id
    public void deleteTrip(long id){}
}
