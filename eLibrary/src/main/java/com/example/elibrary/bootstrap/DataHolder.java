/*
package com.example.elibrary.bootstrap;

import com.example.elibrary.model.Author;
import com.example.elibrary.model.Book;
import com.example.elibrary.model.Country;
import com.example.elibrary.model.enumerations.Category;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder
{
   public static List<Book> books=new ArrayList<>();
   public static List<Author> authors=new ArrayList<>();
   public static List<Country> countries=new ArrayList<>();

   @PostConstruct
   public void init()
   {
      Country country1=new Country(1L,"China","Asia");
      countries.add(country1);
      Country country2=new Country(2L,"England","Europe");
      countries.add(country2);
      Author author1=new Author(1L," Mao","Zedong",country1);
      authors.add(author1);
      Author author2=new Author(2L,"John","Tolkien",country2);
      authors.add(author2);
      Book book1=new Book(1L,"Quotations from Chairman Mao Tse-Tung",4, Category.NOVEL,author1);
      books.add(book1);
      Book book2=new Book(2L,"The Lord Of The Rings",3,Category.FANTASY,author2);
      books.add(book2);
   }
}
*/
