package com.example.Tests;

import com.example.OneToOneSharedPrimaryKey.Address;
import com.example.OneToOneSharedPrimaryKey.Student;
import com.example.Repository.AddressRepository;
import com.example.Repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Marius on 1/21/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TestOneToOneSharedPrimaryKey {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void createTables(){

        Student student1 = new Student("Jack");
        Student student2 = new Student("Nick");
        Student student3 = new Student("Don");

        Address address1 = new Address("first Street");
        Address address2 = new Address("second Street");
        Address address3 = new Address("third Street");

        student1.setAddress(address1);
        student2.setAddress(address2);

        studentRepository.save(student1);
        studentRepository.save(student2);

        /** if we want to save from AddressRepository we need to set also the student in the address first*/
        student3.setAddress(address3);
        address3.setStudent(student3);

        addressRepository.save(address3);

    }
}
