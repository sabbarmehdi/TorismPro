package com.tourism.app.clientManagment.model;

import javax.persistence.Entity;

@Entity(name = "tourist")
public class Tourist extends Client {

    public Tourist(Long id, String firstName, String lastName, String mail, String password, String role) {
        super(id, firstName, lastName, mail, password, role);
    }

    public Tourist() {
    }
}
