package com.example.OneToOneSharedPrimaryKey;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by Marius on 1/21/2017.
 */

/** Consider Student class the Parent*/
@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter(name = "property", value = "address"))
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
