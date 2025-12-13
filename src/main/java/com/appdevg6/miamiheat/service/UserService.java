package com.appdevg6.miamiheat.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdevg6.miamiheat.dto.UpdatePasswordRequest;
import com.appdevg6.miamiheat.entity.UserEntity;
import com.appdevg6.miamiheat.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepo;

    // Register user (no hashing)
    public UserEntity register(UserEntity user) {

        if (userrepo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }

        if (userrepo.existsByIdNumber(user.getIdNumber())) {
            throw new RuntimeException("ID number already registered!");
        }

        // Save as plain text for now
        return userrepo.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userrepo.findAll();
    }

    public UserEntity updateUser(Integer userId, UserEntity newUser) {

        UserEntity user = userrepo.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User " + userId + " does not exist"));

        user.setFirstname(newUser.getFirstname());
        user.setLastname(newUser.getLastname());
        user.setIdNumber(newUser.getIdNumber());
        user.setYearLevel(newUser.getYearLevel());
        user.setProgram(newUser.getProgram());

        return userrepo.save(user);
    }

    public String deleteUser(Integer userId) {
        if (userrepo.existsById(userId)) {
            userrepo.deleteById(userId);
            return "User deleted successfully!";
        }
        return "User does not exist!";
    }

    // Login (plain text)
    public UserEntity login(String email, String rawPassword) {

        UserEntity user = userrepo.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User does not exist!");
        }

        // Compare plain passwords
        if (!rawPassword.equals(user.getPassword())) {
            throw new RuntimeException("Incorrect password!");
        }

        return user;
    }

    // Update password (plain text)
    public String updatePassword(UpdatePasswordRequest req) {

        UserEntity user = userrepo.findById(req.getUserId()).orElse(null);

        if (user == null) {
            return "User not found!";
        }

        if (!req.getCurrentPassword().equals(user.getPassword())) {
            return "Current password incorrect!";
        }

        user.setPassword(req.getNewPassword());
        userrepo.save(user);

        return "Password updated successfully!";
    }
}
