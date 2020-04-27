package com.onke.spring.springboot.api;

import com.onke.spring.springboot.model.User;
import com.onke.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;
    // home page that you see on the root
    @GetMapping("/")
    public String home(){
        return "Welcome To The Home";
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // expose end points for the client to consume
    @PostMapping
    public void addUSer(@Valid @NonNull @RequestBody User user){
        userService.addUser(user.getId(), user.getName(), user.getSurname());
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") long id) {
        userService.remove(id);
    }
    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }
}
