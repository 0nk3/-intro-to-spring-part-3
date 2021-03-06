package com.onke.spring.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.onke.spring.springboot.model.User;
import com.onke.spring.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@EnableAutoConfiguration
@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class UserServiceImplTest {
    // user details to test with
    private final String  name;
    private final String surname;

    @Autowired
    private UserService userService;

    UserServiceImplTest() {
        name = "Linus";
        surname = "Torvalds";
    }

    @Test
    void addUser() {
        assertEquals("Linus", userService.addUser(1,name, surname));
    }

    @Test
    void remove() {
        User user = new User();
        if(user.getId() >= 0){
            System.err.println(user.getName() + " remove!");
            assert(userService.remove(user.getId()) == 0); // assert returns 0 if a user was successfully removed
        }else {
            System.err.println("No such user in the DataBase");
        }
    }

    @Test
    void getUser() {
        User user =  new User();
        user.setName(name);
        user.setSurname(surname);
        user.setId(1);
        assertEquals(user.getId(), userService.getUser(1));  // same user id ==> same user
    }
}