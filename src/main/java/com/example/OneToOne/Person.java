package com.example.OneToOne;

import javax.persistence.*;

/**
 * Created by aniov on 1/20/2017.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String someData;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private CreditCard creditCard;

    public Person() {
    }

    public Person(String someData) {
        this.someData = someData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", someData='" + someData + '\'' +
                '}';
    }
}
