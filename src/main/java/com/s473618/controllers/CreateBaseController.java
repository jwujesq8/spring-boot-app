package com.s473618.controllers;

import com.s473618.services.AuthorService;
import com.s473618.services.ReadService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.s473618.entities.Author;
import com.s473618.entities.Book;
import com.s473618.entities.ReadBooks;
import com.s473618.services.BookService;

import java.util.*;

@RestController
@RequestMapping("/")

public class CreateBaseController {


    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ReadService readService;

    @PostMapping(value = "createBase", produces = MediaType.TEXT_PLAIN_VALUE)
    public String createBase(){

        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");

        DateTime d1 = dtf.parseDateTime("1905-06-21");
        Author a1 = new Author("Jean-Paul", "Sartre", d1);
        Book b1 = new Book("La Nausée", a1, "russian", 350, "roman philosophique");

        DateTime d2 = dtf.parseDateTime("1821-11-11");
        DateTime dr2 = dtf.parseDateTime("2021-05-14");
        Author a2 = new Author("Fyodor", "Dostoevsky", d2);
        Book b2 = new Book("Demons", a2, "russian", 740, "roman philosophique");
        ReadBooks r2 = new ReadBooks(b2, dr2);
        b2.getRead_books().add(r2);

        DateTime d3 = dtf.parseDateTime("1891-05-15");
        DateTime dr3= dtf.parseDateTime("2022-04-24");
        Author a3 = new Author("Mikhail", "Bulgakov", d3);
        Book b3 = new Book("A Young Doctor's Notebook", a3, "russian", 120, "comedy-drama");
        ReadBooks r3 = new ReadBooks(b3, dr3);
        b3.getRead_books().add(r3);

        DateTime dr4 = dtf.parseDateTime("2022-04-13");
        DateTime dr4_1 = dtf.parseDateTime("2022-11-28");
        Book b4 = new Book("Morphine", a3, "russian", 50, "comedy-drama");
        ReadBooks r4 = new ReadBooks(b4, dr4);
        ReadBooks r4_1 = new ReadBooks(b4,dr4_1);
        b4.getRead_books().add(r4);
        b4.getRead_books().add(r4_1);

        DateTime d5 = dtf.parseDateTime("1900-03-23");
        DateTime dr5= dtf.parseDateTime("2022-09-23");
        Author a4 = new Author("Erich", "Fromm", d5);
        Book b5 = new Book("Anatomy of human destructiveness", a4, "russion", 980, "psychology");
        ReadBooks r5 = new ReadBooks(b5, dr5);
        b5.getRead_books().add(r5);

        bookService.saveBook(b1);
        bookService.saveBook(b2);
        bookService.saveBook(b3);
        bookService.saveBook(b4);
        bookService.saveBook(b5);

        return "Base created";
    }
}
