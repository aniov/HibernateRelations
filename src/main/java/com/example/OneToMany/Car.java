package com.example.OneToMany;

import javax.persistence.*;

/**
 * Created by Marius on 1/21/2017.
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;

    @ManyToOne
    /** @JoinColumn(name = "driver_id") OR */
    @PrimaryKeyJoinColumn
    private Driver driver;

    public Car() {
    }

    public Car(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
