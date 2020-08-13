package com.tourism.app.model;

import java.util.Date;

public class TripGuide extends Trip {
    private long id;
    private float price;
    private Date date;

    public TripGuide(long id, String tripName, String description, Trajectory trajectory, long id1, float price, Date date) {
        super(id, tripName, description, trajectory);
        this.id = id1;
        this.price = price;
        this.date = date;
    }

    public TripGuide(long id, float price, Date date) {
        this.id = id;
        this.price = price;
        this.date = date;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
