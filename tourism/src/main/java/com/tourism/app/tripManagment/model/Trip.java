package com.tourism.app.tripManagment.model;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Trip {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "trip_name")
    protected String tripName;

    @Column(name = "description")
    protected String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    protected Trajectory trajectory;


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
