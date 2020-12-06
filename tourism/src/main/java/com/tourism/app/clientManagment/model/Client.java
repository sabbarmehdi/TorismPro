package com.tourism.app.clientManagment.model;


import com.tourism.app.tripManagment.model.Trip;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @NotBlank
    @Size(max = 50)
    private String username;


    @Column(name = "password")
    protected String password;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    protected Set<Role> roles = new HashSet<>();

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trip_client",
                joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "id"))
    @OneToMany(fetch = FetchType.EAGER,mappedBy="client",cascade = CascadeType.ALL)
    private Set<Trip> trips ;*/


    public Client(Long id, String firstName, String lastName, @NotBlank @Size(max = 50) String username, String password, Set<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Client() {
    }

    public Client(String username, String encode) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
