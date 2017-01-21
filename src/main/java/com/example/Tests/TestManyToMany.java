package com.example.Tests;

import com.example.ManyToMany.Book;
import com.example.ManyToMany.Writer;
import com.example.Repository.BookRepository;
import com.example.Repository.WriterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marius on 1/21/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TestManyToMany {

    @Autowired
    WriterRepository writerRepository;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void createTables(){

        Writer writer1 = new Writer("John");
        Writer writer2 = new Writer("Alex");
        Writer writer3 = new Writer("Alicia");

        Book book1 = new Book("Book_One");
        Book book2 = new Book("Book_Two");
        Book book3 = new Book("Book_Three");
        Book book4 = new Book("Book_Four");

        writer1.setBooks(Arrays.asList(book1, book2, book4));
        writer2.setBooks(Arrays.asList(book2, book3, book4));
        writer3.setBooks(Arrays.asList(book1, book4));

        writerRepository.saveAndFlush(writer1);
        writerRepository.saveAndFlush(writer2);
        writerRepository.saveAndFlush(writer3);


        List<Writer> writers = writerRepository.findAll();
        assertTrue(writers.size() >= 3);

        Writer writer = writerRepository.findByName("John");
        assertNotNull("", writer);

        List<Book> books = bookRepository.findByWritersName("Alicia");
        assertEquals("Should have 2 books", books.size(), 2);
        assertTrue("Should have Book_One", books.contains(book1));
        assertTrue("Should have Book_Four", books.contains(book4));
    }
}
