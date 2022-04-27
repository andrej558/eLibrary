package com.example.elibrary.model;

import com.example.elibrary.model.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="author_name")
    private String name;
    private Integer availableCopies;
    @Enumerated
    private Category category;
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String name, Integer availableCopies, Category category, Author author) {
        //this.id = id;
        this.name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }
}
