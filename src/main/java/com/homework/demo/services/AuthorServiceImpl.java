package com.homework.demo.services;

import com.homework.demo.models.Author;
import com.homework.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAll();
    }

    @Override
    public Author getAuthorById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Author addAuthor(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author addAuthor(String firstName, String lastName) {
        Author author = new Author(0, firstName, lastName);
        return this.authorRepository.save(author);
    }
}
