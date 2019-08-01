package com.homework.demo.repositories;

import com.homework.demo.models.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> getAll();

    Author findById(Long id);

    List<Author> findByName(String name);

    Author save(Author author);

    Author update(Author author);
}
