package com.example.ManyToMany;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Marius on 1/21/2017.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    /** Bi-directional association*/
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Writer> writers;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }
}
