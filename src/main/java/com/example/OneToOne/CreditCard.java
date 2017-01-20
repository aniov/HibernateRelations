package com.example.OneToOne;

import javax.persistence.*;

/**
 * Created by aniov on 1/20/2017.
 */
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private int cardNumber;

    public int getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL) /** If 'person' is set in CreditCard, when we save creditCard to DB, person will ALSO Be saved in DB !!!!!*/
                                        /** If we don't have CascadeType.ALL, we have to save also save person in DB */
    @JoinColumn(name = "person_id")
    private Person person;

    public CreditCard() {
    }

    public CreditCard(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", person=" + person +
                '}';
    }
}
