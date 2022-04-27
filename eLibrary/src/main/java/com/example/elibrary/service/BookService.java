package com.example.elibrary.service;

import com.example.elibrary.model.Author;
import com.example.elibrary.model.Book;
import com.example.elibrary.model.dto.BookDto;
import com.example.elibrary.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService
{
    public Optional<Book> findById(Long id);
    public List<Book> findAll();
    public void save(BookDto bookDto);
    public void delete(Long id);
    public void markAsTaken(Long id);
    public void edit(Long id,BookDto bookDto);
}
