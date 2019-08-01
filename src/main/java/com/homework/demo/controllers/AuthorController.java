package com.homework.demo.controllers;

import com.homework.demo.models.Author;
import com.homework.demo.services.AuthorService;
import com.homework.demo.viewmodels.AuthorDTO;
import com.homework.demo.viewmodels.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService authorService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<List<AuthorDTO>> getAll() {
        List<Author> allAuthors = this.authorService.getAllAuthors();

        List<AuthorDTO> authorDTOs = allAuthors.stream()
            .map(author -> this.modelMapper.map(author, AuthorDTO.class))
            .collect(Collectors.toList());

        return new BaseResponse<>(authorDTOs, BaseResponse.SUCCESS);
    }

    @GetMapping(value = "/author/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public BaseResponse<AuthorDTO> getById(@PathVariable(name = "id") Long id) {
        Author author = this.authorService.getAuthorById(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with %d Not Found", id));
        }

        AuthorDTO authorDTO = this.modelMapper.map(author, AuthorDTO.class);

        return new BaseResponse<>(authorDTO, BaseResponse.SUCCESS);
    }

    @PostMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> addAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = this.modelMapper.map(authorDTO, Author.class);

        Author savedAuthor = this.authorService.addAuthor(author);

        return new ResponseEntity<>(savedAuthor.getId(), HttpStatus.CREATED);
    }
}
