package com.tourism.app.tripManagment.model;


import com.tourism.app.clientManagment.model.Client;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Trip {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "trip_name")
    protected String tripName;

    @Column(name = "description")
    protected String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    protected Trajectory trajectory;

    @ManyToMany(mappedBy = "trips")
    private Set<Client> clients = new HashSet<>();

    public Trip() {
    }

    public Trip(long id, String tripName, String description, Trajectory trajectory, Set<Client> clients) {
        this.id = id;
        this.tripName = tripName;
        this.description = description;
        this.trajectory = trajectory;
        this.clients = clients;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(Trajectory trajectory) {
        this.trajectory = trajectory;
    }
}
