package com.tourism.app.tripManagment.model;


import javax.persistence.*;
import java.util.Date;

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


    @Column(name = "trip_period")
    protected int tripPeriod;

    @Column(name = "starting_city")
    protected String startingCity;

    /*@ManyToOne(cascade = CascadeType.ALL)*/
    @Column(name = "Client_id")
    private Long clientId;

    public Trip() {
    }

    public Trip(Long id, String tripName, String description, Trajectory trajectory, int tripPeriod, String startingCity, Long clientId) {
        this.id = id;
        this.tripName = tripName;
        this.description = description;
        this.trajectory = trajectory;
        this.tripPeriod = tripPeriod;
        this.startingCity = startingCity;
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long client) {
        this.clientId = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public int getTripPeriod() {
        return tripPeriod;
    }

    public void setTripPeriod(int tripPeriod) {
        this.tripPeriod = tripPeriod;
    }

    public String getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(String startingCity) {
        this.startingCity = startingCity;
    }
}
