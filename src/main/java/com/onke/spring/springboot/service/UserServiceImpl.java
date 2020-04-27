package com.onke.spring.springboot.service;

import com.onke.spring.springboot.dao.FakeRepoInterface;
import com.onke.spring.springboot.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class.getName());
    // constructor dependency injection
   private final FakeRepoInterface fakeRepo;
    @Autowired
    public UserServiceImpl(@Qualifier("fakeDAO") FakeRepoInterface fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public String addUser(long id, String name, String surname) {
        fakeRepo.insertUser(1, name, surname);
        LOGGER.info(format("%s Entered", name));
        return name;
    }
    @Override
    public int remove(long id) {
        fakeRepo.deleteUser(id);
        LOGGER.info(format("%s removed", getUser(id) ));
        return fakeRepo.deleteUser(id);
    }
    @Override
    public User getUser(long id) {
        LOGGER.info("Hello " + fakeRepo.findById(id).getName());
        return fakeRepo.findById(id);
    }
}
