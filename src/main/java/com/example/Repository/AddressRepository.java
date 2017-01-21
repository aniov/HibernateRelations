package com.example.Repository;

import com.example.OneToOneSharedPrimaryKey.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marius on 1/21/2017.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
}
