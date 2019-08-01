package com.homework.demo.repositories;

import com.homework.demo.models.Author;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Order(1)
    void save() {
        Author author = authorRepository.save(new Author(0, "Saved name", "Saved user"));

        assertEquals(author.getFirstName(), "Saved name");
        assertEquals(author.getLastName(), "Saved user");
        assertTrue(author.getId() > 0);
    }

    @Test
    void updateOrCreate() {
        Author author = authorRepository.update(new Author(0, "author", "test"));
        long id = author.getId();

        assertEquals(authorRepository.findById(id).getFirstName(), "author");

        author.setFirstName("hello");
        authorRepository.update(author);

        assertEquals(authorRepository.findById(id).getFirstName(), "hello");

        author.setLastName("world");
        authorRepository.update(author);

        assertEquals(authorRepository.findById(id).getLastName(), "world");
    }

    @Test
    void getAll() {
        int size = authorRepository.getAll().size();

        authorRepository.save(new Author(0, "Test", "Name"));

        assertEquals(authorRepository.getAll().size(), size + 1);
    }
}