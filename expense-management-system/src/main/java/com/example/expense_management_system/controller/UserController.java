package com.example.expense_management_system.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_management_system.model.User;
import com.example.expense_management_system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Phương thức đăng ký người dùng
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser); // Trả về đối tượng User khi đăng ký thành công
    }

    // Phương thức đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Optional<User> user = userService.login(username, password);
        
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Trả về User nếu đăng nhập thành công
        } else {
            return ResponseEntity.status(401).body("Invalid username or password"); // Trả về lỗi 401 nếu đăng nhập thất bại
        }
    }
}


