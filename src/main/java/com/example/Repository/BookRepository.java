package com.example.Repository;

import com.example.ManyToMany.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

/**
 * Created by Marius on 1/21/2017.
 */
@Entity
public interface BookRepository extends JpaRepository<Book, Integer>{
}
