package com.tourism.app.clientManagment.model;

import com.tourism.app.tripManagment.model.Trip;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "tourist")
public class Tourist extends Client {

    public Tourist(Long id, String firstName, String lastName, @NotBlank @Size(max = 50) String username, String mail, String password, Set<Role> roles, Set<Trip> trips) {
        super(id, firstName, lastName, username, mail, password, roles, trips);
    }

    public Tourist() {
    }

    public Tourist(String username, String email, String encode) {
        super(username, email, encode);
    }
}
