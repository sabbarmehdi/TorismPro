package com.tourism.app.clientManagment.model;

import com.tourism.app.tripManagment.model.Trip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "admin")
public class Admin extends Client{

    @Column(name = "status")
    private boolean status = false;

    public Admin(Long id, String firstName, String lastName, @NotBlank @Size(max = 50) String username, String mail, String password, Set<Role> roles, Set<Trip> trips, boolean status) {
        super(id, firstName, lastName, username, mail, password, roles, trips);
        this.status = status;
    }

    public Admin(boolean status) {
        this.status = status;
    }

    public Admin(String username, String email, String encode, boolean status) {
        super(username, email, encode);
        this.status = status;
    }

    public Admin(String username, String email, String encode) {
    }

    public Admin() {

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
