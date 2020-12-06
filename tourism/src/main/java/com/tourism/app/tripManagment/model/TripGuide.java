package com.tourism.app.tripManagment.model;

import com.tourism.app.clientManagment.model.Client;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "trip_guide")
public class TripGuide extends Trip {

    @Column(name = "price")
    private float price;
    @Column(name = "trip_date")
    private Date tripeDate;

    public TripGuide(float price, Date tripeDate) {
        this.price = price;
        this.tripeDate = tripeDate;
    }

    public TripGuide(java.lang.Long id, String tripName, String description, Trajectory trajectory, Long client, float price, Date tripeDate) {
        super(id, tripName, description, trajectory, client);
        this.price = price;
        this.tripeDate = tripeDate;
    }

    public TripGuide() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getTripeDate() {
        return tripeDate;
    }

    public void setTripeDate(Date tripeDate) {
        this.tripeDate = tripeDate;
    }
}
