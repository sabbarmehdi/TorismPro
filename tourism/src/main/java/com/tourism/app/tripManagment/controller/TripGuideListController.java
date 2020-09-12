package com.tourism.app.tripManagment.controller;

import com.tourism.app.tripManagment.model.TripGuide;
import com.tourism.app.tripManagment.service.tripGuideList.TripGuideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip-guide/list")
public class TripGuideListController {
    private TripGuideListService listService;

    @Autowired
    public TripGuideListController(TripGuideListService listService) {
        this.listService = listService;
    }

    @GetMapping("/all-trips/guide")
    public ResponseEntity<List<TripGuide>> getAllTripsGuide(){
        List<TripGuide> list = listService.retrieveTripsGuide();
        return new ResponseEntity<List<TripGuide>>(list, HttpStatus.OK);
    }
    @GetMapping("/tripguide-by-name/{tripName}")
    public ResponseEntity<List<TripGuide>> getTripsGuideByName(@PathVariable String tripName){
        List<TripGuide> list = listService.retrieveTripsGuideByName(tripName);
        return new ResponseEntity<List<TripGuide>>(list,HttpStatus.OK);
    }
}
