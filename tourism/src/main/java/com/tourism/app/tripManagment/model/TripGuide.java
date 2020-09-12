package com.tourism.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class TripGuide extends Trip {

    @Column(name = "price")
    private float price;
    @Column(name = "trip_date")
    private Date tripeDate;

    public TripGuide(long id, String tripName, String description, Trajectory trajectory, float price, Date tripeDate) {
        super(id, tripName, description, trajectory);
        this.price = price;
        this.tripeDate = tripeDate;
    }

    public TripGuide() {
    }
}
