package com.sadatspringbootcourse.socialmedia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sadatspringbootcourse.socialmedia.customValidation.BirthDateConstraint;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    private Integer id;

    @Size(min = 2,message = "Name must be greater that 2 ")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "birth date must be in the past")
    @BirthDateConstraint(message = "User should be ar least 18 years old")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
