package com.tourism.app.model;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trip {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Trajectory trajectory;


    public Trip() {
    }

    public Trip(long id, String tripName, String description, Trajectory trajectory) {
        this.id = id;
        this.tripName = tripName;
        this.description = description;
        this.trajectory = trajectory;
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
