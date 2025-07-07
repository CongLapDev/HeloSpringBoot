package com.example.hello_spring.controller;

import com.example.hello_spring.dto.request.ApiResponse;
import com.example.hello_spring.dto.request.UserCreationRequest;
import com.example.hello_spring.dto.request.UserUpdateRequest;
import com.example.hello_spring.entity.User;
import com.example.hello_spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
     List<User> getUsers() {
        return    userService.getUsers();
    }


    @PostMapping()
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
       ApiResponse<User> apiResponse = new ApiResponse<>();

       apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
            return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId,  @RequestBody UserUpdateRequest request){
            return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "user has been deleted";
    }
}
