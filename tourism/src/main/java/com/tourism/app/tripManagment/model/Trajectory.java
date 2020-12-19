package com.tourism.app.tripManagment.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "trajectory")
public class Trajectory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "distance")
    private String distance;
    @Column(name = "trajectory_time")
    private Date trajectoryTime;

    @OneToOne(mappedBy = "trajectory")
    private Trip trip;

    public Trajectory() {
    }


    public Trajectory(long id,  String distance, Date trajectoryTime) {
        this.id = id;
        this.distance = distance;
        this.trajectoryTime = trajectoryTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
