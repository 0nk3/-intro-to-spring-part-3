package com.onke.spring.springboot.service;

import com.onke.spring.springboot.model.User;

public interface UserService {
    String addUser(long id, String name, String surname);
    int remove(long id);
    User getUser(long id);
}
