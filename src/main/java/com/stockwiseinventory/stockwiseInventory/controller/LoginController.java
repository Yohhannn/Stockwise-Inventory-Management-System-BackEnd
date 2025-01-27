package com.stockwiseinventory.stockwiseInventory.controller;

import com.stockwiseinventory.stockwiseInventory.model.User;
import com.stockwiseinventory.stockwiseInventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/check-duplicates")
    public ResponseEntity<Map<String, Object>> checkDuplicates(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        boolean hasDuplicate = userService.existsByUsernameOrEmail(user.getUsername(), user.getEmail());

        response.put("hasDuplicate", hasDuplicate);
        response.put("message", hasDuplicate ? "Username or Email already exists!" : "No duplicates found.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        if (userService.existsByUsernameOrEmail(user.getUsername(), user.getEmail())) {
            return ResponseEntity.status(409).body("Username or Email already exists!");
        }
        try {
            userService.saveAccount(user);
            return ResponseEntity.ok("New Account Added.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating account: " + e.getMessage());
        }
    }

    @PostMapping("/authenticate")
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        return userService.login(username, password);
    }
}
