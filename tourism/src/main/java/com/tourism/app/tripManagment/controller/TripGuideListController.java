package com.tourism.app.tripManagment.controller;

import com.tourism.app.tripManagment.model.TripGuide;
import com.tourism.app.tripManagment.model.TripTourist;
import com.tourism.app.tripManagment.service.tripGuideList.TripGuideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/trip-guide/list")
public class TripGuideListController {
    private TripGuideListService listService;

    @Autowired
    public TripGuideListController(TripGuideListService listService) {
        this.listService = listService;
    }

    @GetMapping("/all-trips")
    public ResponseEntity<List<TripGuide>> getAllTripsGuide(){
        List<TripGuide> list = listService.retrieveTripsGuide();
        return new ResponseEntity<List<TripGuide>>(list, HttpStatus.OK);
    }
    @GetMapping("/trip-by-name/{tripName}")
    public ResponseEntity<List<TripGuide>> getTripsGuideByName(@PathVariable String tripName){
        List<TripGuide> list = listService.retrieveTripsGuideByName(tripName);
        return new ResponseEntity<List<TripGuide>>(list,HttpStatus.OK);
    }

    //Get Single Trip Details
    @GetMapping("/single-trip/{tripId}")
    public ResponseEntity<TripGuide> getSingleTripGuide(@PathVariable Long tripId){
        TripGuide trip = listService.retrieveTripById(tripId);
        return new ResponseEntity<TripGuide>(trip, HttpStatus.OK);
    }

    //
    @GetMapping("/user/{clientId}")
    public ResponseEntity<List<TripGuide>> getTripsByUser(@PathVariable Long clientId){
        List<TripGuide> list = listService.retrieveTripsByUser(clientId);
        return new ResponseEntity<List<TripGuide>>(list, HttpStatus.OK);
    }
}
