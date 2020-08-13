package com.tourism.app.model;

import java.util.ArrayList;
import java.util.Date;


public class Trajectory {
    private long id;
    private ArrayList stations;
    private String description;
    private String distance;
    private Date time;

    public Trajectory() {
    }

    public Trajectory(long id, ArrayList stations, String description, String distance, Date time) {
        this.id = id;
        this.stations = stations;
        this.description = description;
        this.distance = distance;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList getStations() {
        return stations;
    }

    public void setStations(ArrayList stations) {
        this.stations = stations;
    }

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
