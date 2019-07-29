package com.homework.demo.services;

import com.homework.demo.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(long id);

    Author getAuthorByName(String name);

    Author addAuthor(String firstName, String lastName);
}
