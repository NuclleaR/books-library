package com.homework.demo.services;

import com.homework.demo.models.Author;
import com.homework.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Author author = authorRepository.findById(id);
        return author;
    }

    @Override
    public Author getAuthorByName(String name) {
        Author author = authorRepository.findByFirstName(name);
        return author;
    }

    @Override
    public Author addAuthor(String firstName, String lastName) {
        Author author = new Author(0, firstName, lastName);
        Author authorSaved = this.authorRepository.save(author);
        System.out.println("Author saved");
        return authorSaved;
    }
}
