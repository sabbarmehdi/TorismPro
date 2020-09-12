package com.tourism.app.clientManagment.controller;

import com.tourism.app.clientManagment.exception.ClientNotFoundException;
import com.tourism.app.clientManagment.model.Client;
import com.tourism.app.clientManagment.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TouristController {
    @Autowired
    private ClientRepo clientRepo;

    //Add new Client
    @PostMapping("/")
    public Client addClient(@RequestBody Client client){
        return (Client) clientRepo.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,
                                               @RequestBody Client clientDetails) throws ClientNotFoundException {

    }
    public void deleteClient(Long id){}
}
