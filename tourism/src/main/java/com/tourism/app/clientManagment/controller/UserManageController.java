package com.tourism.app.clientManagment.controller;

import com.tourism.app.clientManagment.exception.ClientNotFoundException;
import com.tourism.app.clientManagment.model.Client;
import com.tourism.app.clientManagment.model.TourGuide;
import com.tourism.app.clientManagment.model.Tourist;
import com.tourism.app.clientManagment.repository.ClientRepo;
import com.tourism.app.clientManagment.repository.TourGuideRepo;
import com.tourism.app.clientManagment.repository.TouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/manage")
public class UserManageController {
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private TouristRepo touristRepo;
    @Autowired
    private TourGuideRepo tourGuideRepo;

  /* @PostMapping("/")
    public Client addClient(@RequestBody Client client){
        return (Client) clientRepo.save(client);
    }
*/

    @PutMapping("/update-tourist/{touristId}")
    public ResponseEntity<Tourist> updateTourist(@PathVariable Long touristId,
                                               @RequestBody Tourist touristDetails) throws ClientNotFoundException {
        Tourist tourist = touristRepo.findById(touristId)
                .orElseThrow(() -> new ClientNotFoundException("User not found for this Id :: " + touristId));

        tourist.setFirstName(touristDetails.getFirstName());
        tourist.setLastName(touristDetails.getLastName());
        tourist.setMail(touristDetails.getMail());
        tourist.setPassword(touristDetails.getPassword());
        final Tourist updateTourist = clientRepo.save(tourist);
        return ResponseEntity.ok(updateTourist);
    }


    @PutMapping("/update-guide/{guideId}")
    public ResponseEntity<TourGuide> updateTouGuide(@PathVariable Long guideId,
                                                    @RequestBody TourGuide guideDetails) throws ClientNotFoundException{
        TourGuide guide = tourGuideRepo.findById(guideId)
                .orElseThrow(() -> new ClientNotFoundException("User not found for this Id ::" + guideId));
        guide.setFirstName(guideDetails.getFirstName());
        guide.setLastName(guideDetails.getLastName());
        guide.setMail(guideDetails.getMail());
        guide.setPassword(guideDetails.getPassword());
        guide.setCin(guideDetails.getCin());
        guide.setLicense(guideDetails.getLicense());
        guide.setCar(guideDetails.getCar());
        final TourGuide updateGuide = tourGuideRepo.save(guide);
        return ResponseEntity.ok(updateGuide);
    }

    @DeleteMapping("/delete-tourist/{touristId}")
    public Map<String, Boolean> deleteTourist(@PathVariable Long touristId)
            throws ClientNotFoundException{
        Tourist tourist = touristRepo.findById(touristId)
                        .orElseThrow(() -> new ClientNotFoundException("User not found for this ID ::" + touristId));
        touristRepo.delete(tourist);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/delete-guide/{guideId}")
    public Map<String, Boolean> deleteTourGuide(@PathVariable Long guideId)
            throws ClientNotFoundException{
        TourGuide guide = tourGuideRepo.findById(guideId)
                .orElseThrow(() -> new ClientNotFoundException("User not found for this ID ::" + guideId));
        tourGuideRepo.delete(guide);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
    
}
