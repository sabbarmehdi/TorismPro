package com.tourism.app.controller;

import com.tourism.app.model.Trip;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
 Controller to manage Trips
 for Tourist and Tour Guide
 */
@RestController
public class TripManager {
    private ArrayList<Trip> trip;

    public TripManager() {
        trip = new ArrayList<Trip>();
    }

    //add new trip
    @GetMapping("/new-trip")
    public void addTrip(Trip trip){}

    //Update Trip by id
    @PutMapping("/update/{id}")
    public void updateTrip(@PathVariable long id){}

    //delete Trip by id
    @DeleteMapping("/remove/{id}")
    public void deleteTrip(@PathVariable long id){}
}
