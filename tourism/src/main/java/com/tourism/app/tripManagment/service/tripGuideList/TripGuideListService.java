package com.tourism.app.tripManagment.service.tripGuideList;


import com.tourism.app.tripManagment.model.TripGuide;
import com.tourism.app.tripManagment.model.TripTourist;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripGuideListService {
    List<TripGuide> retrieveTripsGuide();
    List<TripGuide> retrieveTripsGuideByName(String tripGuideName);
    TripGuide retrieveTripById(Long id);
    List<TripGuide> retrieveTripsByUser(Long clientId);

    //List<TripGuide> retrieveTripsByStartCity();
}
