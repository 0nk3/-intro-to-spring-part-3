package com.onke.spring.springboot.model;

import javax.validation.constraints.NotNull;

public class User {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    public User() {
        //
    }

    public User(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

