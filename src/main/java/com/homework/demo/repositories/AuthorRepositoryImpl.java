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
        Author author = entityManager.find(Author.class, id);
        return author;
    }

    @Override
    public Author findByFirstName(String name) {
        TypedQuery<Author> query = entityManager.createQuery(
            "select author from Author author where lower(author.firstName) like lower(concat('%', :name,'%'))",
            Author.class
        );
        query.setParameter("name", name);

        Author author;

        try {
            author = query.getSingleResult();
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
            author = null;
        }
        return author;
    }

    @Override
    public Author save(Author author) {
        entityManager.persist(author);
        return author;
    }
}
