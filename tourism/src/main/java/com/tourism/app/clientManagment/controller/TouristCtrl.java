package com.tourism.app.clientManagment.controller;

import com.tourism.app.clientManagment.model.Tourist;
import com.tourism.app.clientManagment.repository.TouristRepo;
import com.tourism.app.clientManagment.services.TouristService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/one-user")
public class TouristCtrl {
    private TouristService touristService;
    private TouristRepo touristRepo;
    private static final Logger logger = LoggerFactory.getLogger(TouristCtrl.class);

    public TouristCtrl(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Tourist> getTouristById(@PathVariable Long id){
        Tourist tourist = touristService.getTouristById(id);
        logger.info("TouristCtrl Test: " + tourist);
        return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tourist> getTouristByI(@PathVariable Long id){
        return ResponseEntity.of(touristRepo.findById(id));
    }
}
