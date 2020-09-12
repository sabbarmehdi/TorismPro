package com.tourism.app.service.tripGuideList;


import com.tourism.app.model.TripGuide;

import java.util.List;

public interface TripGuideListService {
    List<TripGuide> retrieveTripsGuide();
    List<TripGuide> retrieveTripsGuideByName(String tripGuideName);
    //List<TripGuide> retrieveTripsByStartCity();
}
