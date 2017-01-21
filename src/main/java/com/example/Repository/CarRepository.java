package com.example.Repository;

import com.example.OneToMany.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marius on 1/21/2017.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
}
