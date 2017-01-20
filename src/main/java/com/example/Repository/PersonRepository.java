package com.example.Repository;

import com.example.OneToOne.CreditCard;
import com.example.OneToOne.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aniov on 1/20/2017.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByCreditCardCardNumber(int cardNumber);

}
