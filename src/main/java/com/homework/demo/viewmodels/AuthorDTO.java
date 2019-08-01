package com.homework.demo.viewmodels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings({"unused"})
public class AuthorDTO {

    @NotNull
    private long id;

    @NotNull(message = "First name is missing")
    @Size(max = 24, message = "First name cannot be more then 24 characters")
    private String firstName;

    @NotNull(message = "Last name is missing")
    @Size(max = 24, message = "Last name cannot be more then 24 characters")
    private String lastName;

    public AuthorDTO() {
    }

    public AuthorDTO(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
