package com.example.elibrary.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="author_name")
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author(String name, String surname, Country country)
    {

        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Author() {}
}
