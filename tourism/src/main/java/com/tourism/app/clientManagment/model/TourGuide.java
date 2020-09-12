package com.tourism.app.clientManagment.model;

import javax.persistence.*;

@Entity(name = "tour_guide")
public class TourGuide extends Client{

    @Column(name = "cin")
    private String cin;
    @Column(name = "license")
    private String license;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Car car;

    public TourGuide() {
    }

    public TourGuide(Long id, String firstName, String lastName, String mail, String password, String role, String cin, String license, Car car) {
        super(id, firstName, lastName, mail, password, role);
        this.cin = cin;
        this.license = license;
        this.car = car;
    }

    public TourGuide(String cin, String license, Car car) {
        this.cin = cin;
        this.license = license;
        this.car = car;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
