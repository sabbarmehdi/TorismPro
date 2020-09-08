package com.tourism.app.service.tripList;

import com.tourism.app.model.Trip;
import com.tourism.app.repository.TripListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripListImpService implements TripListService {
    @Autowired
    TripListRepo tripListRepo;

    public List<Trip> retrieveTrips() {
        return (List<Trip>) tripListRepo.findAll();
    }

    public List<Trip> retrieveTripsByName(String tripName) {
        /*Optional<List<Trip>> optionalTrip = Optional.ofNullable(tripListRepo.findTripsByName(tripName));
        List<Trip> trip = optionalTrip.orElseThrow(TripNotFoundException::new);*/
        return (List<Trip>) tripListRepo.findTripsByName(tripName);
    }
}
