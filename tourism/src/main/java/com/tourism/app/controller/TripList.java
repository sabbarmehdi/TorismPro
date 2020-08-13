package com.tourism.app.controller;

import com.tourism.app.model.Trip;
import org.springframework.http.ResponseEntity;

import java.util.List;

/*
 Controller that fitch Tips in a List
 and provide an advance search by Name or by City
 */
public class TripList {

    //Get all Tips
    public ResponseEntity<List<Trip>> getAllTrips(){
        return null;
    }

    //Get Trips by Name
    public ResponseEntity<List<Trip>> getTripsByName(){
        return null;
    }

    //Get Trips by City
    public ResponseEntity<List<Trip>> getTripsByCity(){
     return null;
    }
}
