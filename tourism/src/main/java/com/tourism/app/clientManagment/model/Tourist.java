package com.tourism.app.clientManagment.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "tourist")
public class Tourist extends Client {

    public Tourist(Long id, String firstName, String lastName, @NotBlank @Size(max = 50) String username, String password, Set<Role> roles) {
        super(id, firstName, lastName, username, password, roles);
    }

    public Tourist(String username, String encode) {
        super(username, encode);
    }

    public Tourist() {
    }

}
