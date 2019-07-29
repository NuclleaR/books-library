package com.homework.demo;

import com.homework.demo.models.Author;
import com.homework.demo.services.AuthorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.h2.tools.Console;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        try {
            Console.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
