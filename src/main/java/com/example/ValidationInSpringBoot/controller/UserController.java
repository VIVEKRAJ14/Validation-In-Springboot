package com.example.ValidationInSpringBoot.controller;

import com.example.ValidationInSpringBoot.model.User;
import com.example.ValidationInSpringBoot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/Controller")
@Validated

public class UserController {

        @Autowired
        UserService userService;

        @PostMapping(value = "/addUser")
        public String addUser(@Valid @RequestBody User user)
        {
                return userService.addNew(user);
        }

        @GetMapping(value = "/getAllUser")
        public List<User> getAllUser()
        {
                return userService.getAll();
        }

        @GetMapping(value = "/getUser/{userid}")
        public User getUser(int userid)
        {
                return userService.getUserById(userid);
        }

        @PutMapping(value = "updateUserInfo/{userid}")
        public String updateUserInfo(@PathVariable int userid, @RequestBody User user)
        {
                return userService.updateUser(userid,user);
        }

        @DeleteMapping(value = "/deleteUser/{userid}")
        public String deleteUser(@PathVariable int userid)
        {
                return userService.deleteUserById(userid);
        }


}