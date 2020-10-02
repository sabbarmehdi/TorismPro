package com.tourism.app.tripManagment.service.tripList;

import com.tourism.app.tripManagment.exception.TripNotFoundException;
import com.tourism.app.tripManagment.model.TripTourist;
import com.tourism.app.tripManagment.repository.TripTouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripListImpService implements TripListService {
    @Autowired
    TripTouristRepo tripTouristRepo;

   @Override
    public List<TripTourist> retrieveTrips() {
        return (List<TripTourist>) tripTouristRepo.findAll();
    }

    @Override
    public List<TripTourist> retrieveTripsByName(String tripName) {
        /*Optional<List<Trip>> optionalTrip = Optional.ofNullable(tripListRepo.findTripsByName(tripName));
        List<Trip> trip = optionalTrip.orElseThrow(TripNotFoundException::new);
        return trip;*/
        return (List<TripTourist>) tripTouristRepo.findTripsByName(tripName);
    }

    @Override
    public TripTourist retrieveTripById(Long id) {
        Optional<TripTourist> optionalTripTourist = Optional.ofNullable(tripTouristRepo.findTripById(id));
        TripTourist tripTourist = optionalTripTourist.orElseThrow(TripNotFoundException::new);
        return tripTourist;
    }
}
