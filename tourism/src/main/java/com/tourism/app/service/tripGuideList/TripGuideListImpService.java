package com.tourism.app.service.tripGuideList;

import com.tourism.app.model.TripGuide;
import com.tourism.app.repository.TripGuideListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripGuideListImpService implements TripGuideListService {
    @Autowired
    TripGuideListRepo tripGuideListRepo;


    public List<TripGuide> retrieveTripsGuide() {
        return (List<TripGuide>) tripGuideListRepo.findAll();
    }

    public List<TripGuide> retrieveTripsGuideByName(String tripGuideName) {
        return (List<TripGuide>) tripGuideListRepo.findTripsGuideByName(tripGuideName);
    }
}
