package com.tourism.app.tripManagment.controller;

import com.tourism.app.tripManagment.model.TripGuide;
import com.tourism.app.tripManagment.model.TripTourist;
import com.tourism.app.tripManagment.service.tripList.TripListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 Controller that fitch Tips in a List
 and provide an advance search by Name or by City
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/trip/list")
public class TripListController {
    private TripListService tripListService;

    @Autowired
    public TripListController(TripListService tripListService) {
        this.tripListService = tripListService;
    }

    //Get all Tips
    @GetMapping("/all-trips")
    public ResponseEntity<List<TripTourist>> getAllTrips(){
        List<TripTourist> list = tripListService.retrieveTrips();
        return new ResponseEntity<List<TripTourist>>(list, HttpStatus.OK);
    }

    //Get Trips by Name
    @GetMapping("/trip-by-name/{tripName}")
    public ResponseEntity<List<TripTourist>> getTripByName(@PathVariable String tripName){
       List<TripTourist> list = tripListService.retrieveTripsByName(tripName);
       return new ResponseEntity<List<TripTourist>>(list, HttpStatus.OK);
    }

    //Get Single Trip Details
    @GetMapping("/single-trip/{tripId}")
    public ResponseEntity<TripTourist> getSingleTrip(@PathVariable Long tripId){
        TripTourist trip = tripListService.retrieveTripById(tripId);
        return new ResponseEntity<TripTourist>(trip, HttpStatus.OK);
    }

    @GetMapping("/user/{clientId}")
    public ResponseEntity<List<TripTourist>> getTripsByUser(@PathVariable Long clientId){
        List<TripTourist> list = tripListService.retrieveTripsByClient(clientId);
        return new ResponseEntity<List<TripTourist>>(list, HttpStatus.OK);
    }

    //Get Trips by City search
    /*public ResponseEntity<List<Trip>> getTripsByCity(){
     return null;
    }
     */
}
