package com.tourism.app.tripManagment.model;

import com.tourism.app.clientManagment.model.Client;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
public class TripGuide extends Trip {

    @Column(name = "price")
    private float price;
    @Column(name = "trip_date")
    private Date tripeDate;

    public TripGuide(float price, Date tripeDate) {
        this.price = price;
        this.tripeDate = tripeDate;
    }

    public TripGuide(long id, String tripName, String description, Trajectory trajectory, Set<Client> clients, float price, Date tripeDate) {
        super(id, tripName, description, trajectory, clients);
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
