package com.tourism.app.tripManagment.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "trajectory")
public class Trajectory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //private ArrayList stations;
    @Column(name = "description")
    private String description;
    @Column(name = "distance")
    private String distance;
    @Column(name = "trajectory_time")
    private Date trajectoryTime;

    @OneToOne(mappedBy = "trajectory")
    private Trip trip;

    public Trajectory() {
    }


    public Trajectory(long id, /*ArrayList stations,*/ String description, String distance, Date trajectoryTime) {
        this.id = id;
       // this.stations = stations;
        this.description = description;
        this.distance = distance;
        this.trajectoryTime = trajectoryTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
   /*
    public ArrayList getStations() {
        return stations;
    }

    public void setStations(ArrayList stations) {
        this.stations = stations;
    }
*/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Date getTrajectoryTime() {
        return trajectoryTime;
    }

    public void setTrajectoryTime(Date time) {
        this.trajectoryTime = time;
    }
}
