package com.example.Tests;

import com.example.OneToOne.CreditCard;
import com.example.OneToOne.Person;
import com.example.Repository.CreditCardRepository;
import com.example.Repository.PersonRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aniov on 1/20/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TestOne {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CreditCardRepository creditCardRepository;

    @Ignore
    @Test
    public void createPersonAndCreditCard(){

        Person person = new Person("text_one");
        /** We have to save person to DB if we don't use cascade = CascadeType.ALL in CreditCard Entity*/
        /** personRepository.save(person); */

        CreditCard creditCard = new CreditCard(12345);
        creditCard.setPerson(person);

        creditCardRepository.save(creditCard);

        CreditCard creditCardResult = creditCardRepository.findOne(creditCard.getId());

        Assert.assertNotNull(creditCardResult);
        //System.out.println(creditCardResult);
    }

    @Test
    public void testRepository(){

        /** */
        List<CreditCard> creditCards = creditCardRepository.findAll();
        System.out.println("Credit cards Result:\n");
        Assert.assertNotNull(creditCards + "\n");

        List<Person> personList = personRepository.findByCreditCardCardNumber(12345);
        System.out.println("Person List searched after CreditCard-cardNumber:\n" + personList +"\n");

        CreditCard creditCard = creditCardRepository.findByPersonSomeData("text_one");
        System.out.println("CreditCard searched after Person-someData:\n" + creditCard + "\n");



    }

}
