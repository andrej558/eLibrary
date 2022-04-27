package com.example.elibrary.service.impl;

import com.example.elibrary.model.Author;
import com.example.elibrary.model.Book;
import com.example.elibrary.model.Country;
import com.example.elibrary.model.dto.BookDto;
import com.example.elibrary.model.enumerations.Category;
import com.example.elibrary.model.exceptions.AuthorNotFoundException;
import com.example.elibrary.model.exceptions.BookNotFoundException;
import com.example.elibrary.repository.*;
import com.example.elibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService
{

    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(CountryRepository countryRepository, BookRepository bookRepository, AuthorRepository authorRepository)
    {
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;


        if(this.countryRepository.findAll().isEmpty())
        {
            this.countryRepository.save(new Country("Brazil", "South America"));
            this.countryRepository.save(new Country("Greece", "Europe"));
            this.authorRepository.save(new Author("Georges","Simenon",this.countryRepository.findById(1L).get()));
            this.authorRepository.save(new Author("Clint","Smith",this.countryRepository.findById(2L).get()));
            this.bookRepository.save(new Book("She: A History of Adventure",5,Category.NOVEL,this.authorRepository.findById(1L).get()));
            this.bookRepository.save(new Book("How the Word Is Passed: A Reckoning With the History of Slavery Across America",10,Category.HISTORY,this.authorRepository.findById(2L).get()));
        }

    }

    @Override
    public Optional<Book> findById(Long id)
    {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }

    @Override
    public void save(BookDto bookDto)
    {
        Author author=authorRepository.findById(bookDto.getAuthor()).orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));
        Book book=new Book(bookDto.getName(),bookDto.getAvailableCopies(),bookDto.getCategory(),author);
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public void markAsTaken(Long id)
    {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
        //return book;
    }

    @Override
    public void edit(Long id,BookDto bookDto)
    {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        Author author=authorRepository.findById(bookDto.getAuthor()).orElseThrow(()->new AuthorNotFoundException(id));
        book.setAuthor(author);
        bookRepository.save(book);
    }
}
