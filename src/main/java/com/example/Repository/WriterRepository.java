package com.example.Repository;

import com.example.ManyToMany.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marius on 1/21/2017.
 */
@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer>{
}
