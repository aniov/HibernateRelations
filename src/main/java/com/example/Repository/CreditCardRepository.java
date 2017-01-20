package com.example.Repository;

import com.example.OneToOne.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aniov on 1/20/2017.
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{

    CreditCard findByPersonSomeData(String someData);
}
