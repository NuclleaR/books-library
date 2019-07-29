package com.homework.demo.shell;

// import com.homework.demo.model.Book;

import com.homework.demo.models.Author;
import com.homework.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.Optional;

@Profile("shell")
@ShellComponent
public class BooksShell {

    private final AuthorService authorService;

    @Autowired
    public BooksShell(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod("Adds author to DB")
    public void author(@ShellOption(value = {"--name", "-n"}, arity = 2) String[] name) {
        Author author = this.authorService.addAuthor(name[0], name[1]);
        System.out.println("You added:" + author);
    }

    @ShellMethod("Get user by ID")
    public void get(
        @ShellOption(value = {"--id", "-i"}, arity = 1, defaultValue = "-1") Long id,
        @ShellOption(value = {"--name", "-n"}, arity = 1, defaultValue = "") String name
    ) {
        if (id >= 0) {
            Author author = authorService.getAuthorById(id);
            System.out.println(author);
        } else if (id < 0 && !name.isEmpty()) {
            Author author = authorService.getAuthorByName(name);
            System.out.println(author);
        } else {
            System.out.println("At least one option should be passed");
        }
    }

    @ShellMethod("Get user by ID")
    public void get_all() {
        List<Author> authors = authorService.getAllAuthors();
        System.out.println(authors);
    }

    @ShellMethod(value = "Display stuff.", prefix = "-")
    public String echo(String e) {
        return String.format("You said a=%s", e);
    }
}
