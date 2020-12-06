package com.tourism.app.clientManagment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "admin")
public class Admin extends Client {

    @Column(name = "status")
    private boolean status = false;

    public Admin(Long id, String firstName, String lastName, @NotBlank @Size(max = 50) String username, String password, Set<Role> roles, boolean status) {
        super(id, firstName, lastName, username, password, roles);
        this.status = status;
    }

    public Admin(boolean status) {
        this.status = status;
    }

    public Admin(String username, String encode, boolean status) {
        super(username, encode);
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
