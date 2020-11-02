package com.tourism.app.tripManagment.controller;

import com.tourism.app.tripManagment.exception.TripNotFoundException;
import com.tourism.app.tripManagment.model.Trajectory;
import com.tourism.app.tripManagment.model.Trip;
import com.tourism.app.tripManagment.model.TripGuide;
import com.tourism.app.tripManagment.repository.TrajectoryRepo;
import com.tourism.app.tripManagment.repository.TripGuideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/trip-guide")
public class TripGuideManagerController {
    @Autowired
    private TripGuideRepo guideRepo;

    @Autowired
    private TrajectoryRepo trajectoryRepo;

    //add new trip
    @PostMapping("/new-trip")
    public TripGuide addTrip(@RequestBody TripGuide trip){
        return guideRepo.save(trip);
    }

    //Update Trip by id
    @PutMapping("/update-trip/{id}")
    public ResponseEntity<TripGuide> updateTrip(@PathVariable(value = "id") Long tripId,
                                           @RequestBody TripGuide tripDetails) throws TripNotFoundException {
        TripGuide trip = guideRepo.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException("Trip not found for this Id :: " + tripId));

        trip.setTripName(tripDetails.getTripName());
        trip.setDescription(tripDetails.getDescription());
        //trajectoryRepo.deleteById(trip.getTrajectory().getId());
        //trip.setTrajectory(tripDetails.getTrajectory());

        Trajectory trajectory = trajectoryRepo.findById(trip.getTrajectory().getId()).get();
        trajectory.setDescription(trip.getTrajectory().getDescription());
        trajectory.setDistance(trip.getTrajectory().getDistance());
        trajectory.setTrajectoryTime(trip.getTrajectory().getTrajectoryTime());
        Trajectory savedTrajectory = trajectoryRepo.save(trajectory);

        trip.setTrajectory(savedTrajectory);

        final TripGuide updatedTrip = guideRepo.save(trip);
        return ResponseEntity.ok(updatedTrip);
    }

    //delete Trip by id
    @DeleteMapping("/delete-trip/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value = "id") long tripId)
            throws TripNotFoundException{
        TripGuide trip = guideRepo.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException("Trip not found for this id :: " + tripId));
        guideRepo.delete(trip);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
