package com.example.elibrary.controller;

import com.example.elibrary.model.Author;
import com.example.elibrary.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController
{
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }
    @GetMapping()
    public List<Author> findAll()
    {
        return authorService.findAll();
    }
}
