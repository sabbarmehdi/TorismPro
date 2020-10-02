package com.tourism.app.tripManagment.service.tripGuideList;

import com.tourism.app.tripManagment.exception.TripNotFoundException;
import com.tourism.app.tripManagment.model.TripGuide;
import com.tourism.app.tripManagment.repository.TripGuideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripGuideListImpService implements TripGuideListService {
    @Autowired
    TripGuideRepo tripGuideRepo;


    public List<TripGuide> retrieveTripsGuide() {
        return (List<TripGuide>) tripGuideRepo.findAll();
    }

    public List<TripGuide> retrieveTripsGuideByName(String tripGuideName) {
        return (List<TripGuide>) tripGuideRepo.findTripsGuideByName(tripGuideName);
    }

    @Override
    public TripGuide retrieveTripById(Long id) {
        Optional<TripGuide> optionalTripGuide = Optional.ofNullable(tripGuideRepo.findTripGuideById(id));
        TripGuide tripGuide = optionalTripGuide.orElseThrow(TripNotFoundException::new);
        return tripGuide;
    }
}
