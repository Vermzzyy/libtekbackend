package com.appdevg6.miamiheat.controller;


import org.springframework.web.bind.annotation.*;

import com.appdevg6.miamiheat.dto.LoginRequest;
import com.appdevg6.miamiheat.dto.UpdatePasswordRequest;
import com.appdevg6.miamiheat.entity.UserEntity;
import com.appdevg6.miamiheat.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/postUser")
    public UserEntity postUser(@RequestBody UserEntity userEntity) {
        return userService.register(userEntity);
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser/{user_id}")
    public UserEntity updateUser(@PathVariable Integer user_id, @RequestBody UserEntity newUser) {
        return userService.updateUser(user_id, newUser);
    }

    @DeleteMapping("/deleteUser/{user_id}")
    public String deleteUser(@PathVariable Integer user_id) {
        return userService.deleteUser(user_id);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody LoginRequest request) {
    return userService.login(request.getEmail(), request.getPassword());
    }

    @PutMapping("/updatePassword")
    public String updatePassword(@RequestBody UpdatePasswordRequest req) {
        return userService.updatePassword(req);
    }
}
