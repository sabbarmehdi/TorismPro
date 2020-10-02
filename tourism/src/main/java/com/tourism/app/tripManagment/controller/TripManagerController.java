package com.tourism.app.tripManagment.controller;

import com.tourism.app.tripManagment.exception.TripNotFoundException;
import com.tourism.app.tripManagment.model.Trip;
import com.tourism.app.tripManagment.model.TripTourist;
import com.tourism.app.tripManagment.repository.TrajectoryRepo;
import com.tourism.app.tripManagment.repository.TripTouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
 Controller to manage Trips
 for Tourist and Tour Guide
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/trip")
public class TripManagerController {
    @Autowired
    private TripTouristRepo touristRepo;
    @Autowired
    private TrajectoryRepo trajectoryRepo;

    //add new trip
    @PostMapping("/new-trip")
    public TripTourist addTrip(@RequestBody TripTourist trip){
        return touristRepo.save(trip);
    }

    //Update Trip by id

    @PutMapping("/update-trip/{id}")
    public ResponseEntity<TripTourist> updateTrip(@PathVariable(value = "id") Long tripId,
                                                  @RequestBody TripTourist tripDetails) throws TripNotFoundException {
        TripTourist trip = touristRepo.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException("Trip not found for this Id :: " + tripId));

        trip.setTripName(tripDetails.getTripName());
        trip.setDescription(tripDetails.getDescription());
        trajectoryRepo.deleteById(trip.getTrajectory().getId());
        trip.setTrajectory(tripDetails.getTrajectory());
        final TripTourist updatedTrip = touristRepo.save(trip);
        return ResponseEntity.ok(updatedTrip);
    }

    //delete Trip by id
    @DeleteMapping("/delete-trip/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value = "id") long tripId)
        throws TripNotFoundException{
        TripTourist trip = touristRepo.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException("Trip not found for this id :: " + tripId));
        touristRepo.delete(trip);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
