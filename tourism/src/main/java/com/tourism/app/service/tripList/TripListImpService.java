package com.tourism.app.service.tripList;

import com.tourism.app.model.TripTourist;
import com.tourism.app.repository.TripListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripListImpService implements TripListService {
    @Autowired
    TripListRepo tripListRepo;

    public List<TripTourist> retrieveTrips() {
        return (List<TripTourist>) tripListRepo.findAll();
    }

    public List<TripTourist> retrieveTripsByName(String tripName) {
        /*Optional<List<Trip>> optionalTrip = Optional.ofNullable(tripListRepo.findTripsByName(tripName));
        List<Trip> trip = optionalTrip.orElseThrow(TripNotFoundException::new);*/
        return (List<TripTourist>) tripListRepo.findTripsByName(tripName);
    }
}
