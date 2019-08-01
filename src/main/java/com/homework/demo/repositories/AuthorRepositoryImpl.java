package com.homework.demo.repositories;

import com.homework.demo.models.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = entityManager.createQuery("select a from Author a", Author.class);

        return query.getResultList();
    }

    @Override
    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = entityManager.createQuery(
            "select author from Author author where " +
                "lower(author.firstName) like lower(concat('%', :name,'%')) or " +
                "lower(author.lastName) like lower(concat('%', :name,'%'))",
            Author.class
        );
        query.setParameter("name", name);

        List<Author> authors;

        try {
            authors = query.getResultList();
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
            authors = null;
        }
        return authors;
    }

    @Override
    public Author save(Author author) {
        entityManager.persist(author);
        entityManager.refresh(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }
}
