package com.example.elibrary.service.impl;

import com.example.elibrary.model.Author;
import com.example.elibrary.repository.AuthorRepository;
import com.example.elibrary.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService
{
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll()
    {
        return authorRepository.findAll();
    }
}
