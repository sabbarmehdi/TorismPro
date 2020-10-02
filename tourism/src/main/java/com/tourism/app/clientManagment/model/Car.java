package com.tourism.app.clientManagment.model;


import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "registration_num")
    private String registrationNum;
    @Column(name = "model")
    private String model;
    @Column(name = "owner")
    private String owner;
    @Column(name = "seats_num")
    private int seatsNum;

    @OneToOne(mappedBy = "car")
    private TourGuide tourGuide;

    public Car(Long id, String registrationNum, String model, String owner, int seatsNum, com.tourism.app.clientManagment.model.TourGuide tourGuide) {
        this.id = id;
        this.registrationNum = registrationNum;
        this.model = model;
        this.owner = owner;
        this.seatsNum = seatsNum;
        this.tourGuide = tourGuide;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public void setSeatsNum(int seatsNum) {
        this.seatsNum = seatsNum;
    }

    public com.tourism.app.clientManagment.model.TourGuide getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(TourGuide tourGuide) {
        this.tourGuide = tourGuide;
    }
}
