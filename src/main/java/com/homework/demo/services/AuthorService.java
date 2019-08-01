package com.homework.demo.services;

import com.homework.demo.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(long id);

    List<Author> getAuthorByName(String name);

    Author addAuthor(Author author);

    Author addAuthor(String firstName, String lastName);
}
