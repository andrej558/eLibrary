package com.example.elibrary.model.exceptions;

public class BookNotFoundException extends RuntimeException
{
    public BookNotFoundException(Long id)
    {
        super(String.format("Book with %d id is not found",id));
    }
}
