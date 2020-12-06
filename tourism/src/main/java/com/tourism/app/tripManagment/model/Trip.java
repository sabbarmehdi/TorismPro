package com.tourism.app.tripManagment.model;


import com.tourism.app.clientManagment.model.Client;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Trip {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    protected java.lang.Long id;

    @Column(name = "trip_name")
    protected String tripName;

    @Column(name = "description")
    protected String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    protected Trajectory trajectory;

    /*@ManyToOne(cascade = CascadeType.ALL)*/
    @Column(name = "Client_id")
    private Long clientId;

    public Trip() {
    }

    public Trip(java.lang.Long id, String tripName, String description, Trajectory trajectory, Long client) {
        this.id = id;
        this.tripName = tripName;
        this.description = description;
        this.trajectory = trajectory;
        this.clientId = client;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long client) {
        this.clientId = client;
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
