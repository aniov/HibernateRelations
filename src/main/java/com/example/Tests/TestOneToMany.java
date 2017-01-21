package com.example.Tests;

import com.example.OneToMany.Car;
import com.example.OneToMany.Driver;
import com.example.Repository.CarRepository;
import com.example.Repository.DriverRepository;
import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marius on 1/21/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TestOneToMany {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CarRepository carRepository;

    @Test
    public void createTables(){

        Driver driver1 = new Driver("KKevin");
        driverRepository.save(driver1); /** We can save Driver now and then set & save the cars to this driver*/

        Car car1 = new Car("Dacia"); car1.setDriver(driver1); carRepository.save(car1);
        Car car2 = new Car("Porche");car2.setDriver(driver1); carRepository.save(car2);
        Car car3 = new Car("Mazda");car3.setDriver(driver1); carRepository.save(car3);

        /** Or we can make a list with cars (we set driver for them), and set all the cars to the driver, then save the driver*/
        //List<Car> cars = new ArrayList<>();
        //cars.addAll(Arrays.asList(car1, car2, car3));
        //driver1.setCars(cars);


        Driver testDriver = driverRepository.findByName("KKevin");
        assertNotNull("testDriver should not be null", testDriver);
        assertEquals("Name should be same", "KKevin", testDriver.getName());
        /** Working only without @Transactional*/
        //assertTrue("Should be 3 cars", testDriver.getCars().size() == 3); /** Because we have fetch = FetchType.EAGER in Driver we can do .size()*/


    }
}
