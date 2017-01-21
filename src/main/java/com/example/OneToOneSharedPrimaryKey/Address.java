package com.example.OneToOneSharedPrimaryKey;

import javax.persistence.*;

/**
 * Created by Marius on 1/21/2017.
 */
/** Consider Student class the Child*/
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String street;

    /** Bi-directional*/
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Student student;

    public Address() {
    }

    public Address(String street) {
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
