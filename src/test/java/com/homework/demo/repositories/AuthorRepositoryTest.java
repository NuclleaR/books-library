package com.homework.demo.repositories;

import com.homework.demo.models.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void save() {

        Author author = authorRepository.save(new Author(0, "Test", "Name"));

        assertEquals(author.getFirstName(), "Test");
        assertEquals(author.getLastName(), "Name");
        assertTrue(author.getId() > 0);
    }

    @Test
    void getAll() {
        authorRepository.save(new Author(0, "Test", "Name"));
        authorRepository.save(new Author(0, "Test2", "Name2"));

        assertEquals(authorRepository.getAll().size(), 2);

        for (Author author : authorRepository.getAll()) {
            assertNotNull(author.getFirstName());
            assertNotNull(author.getFirstName());
        }
    }
}