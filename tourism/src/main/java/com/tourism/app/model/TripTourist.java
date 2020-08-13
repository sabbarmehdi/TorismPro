package com.tourism.app.model;

public class TripTourist extends Trip {
    private long id;

    public TripTourist(long id, String tripName, String description, Trajectory trajectory, long id1) {
        super(id, tripName, description, trajectory);
        this.id = id1;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
