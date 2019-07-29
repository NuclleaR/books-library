package com.homework.demo.repositories;

import com.homework.demo.models.Author;

import java.util.List;

public interface AuthorRepository  {
    public List<Author> getAll();
    public Author findById(Long id);
    public Author findByFirstName(String name);
    public Author save(Author author);
}
