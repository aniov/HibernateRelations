package com.example.Repository;

import com.example.ManyToMany.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Marius on 1/21/2017.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    List<Book> findByWritersName(String name);
}
