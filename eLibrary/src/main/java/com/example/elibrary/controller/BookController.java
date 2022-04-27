package com.example.elibrary.controller;

import com.example.elibrary.model.Book;
import com.example.elibrary.model.dto.BookDto;
import com.example.elibrary.model.enumerations.Category;
import com.example.elibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController
{
    private final BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll()
    {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable Long id)
    {
       return bookService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity booksAfterDeleting(@PathVariable Long id)
    {
        bookService.delete(id);
        if(bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();

    }
    @GetMapping("/markastaken/{id}")
    public void markAsTakenBook(@PathVariable Long id)
    {
        bookService.markAsTaken(id);
        //return bookService.findAll();
        //return bookService.findById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody BookDto bookDto)
   {
       bookService.save(bookDto);
   }


    @PostMapping("/edit/{id}")
    public void edit(@PathVariable Long id,
                     @RequestBody BookDto bookDto)
   {
       bookService.edit(id,bookDto);
   }
}
