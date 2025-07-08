package com.example.hello_spring.service;

import com.example.hello_spring.dto.request.UserCreationRequest;
import com.example.hello_spring.dto.request.UserUpdateRequest;
import com.example.hello_spring.entity.User;
import com.example.hello_spring.exception.AppException;
import com.example.hello_spring.exception.ErrorCode;
import com.example.hello_spring.mapper.UserMapper;
import com.example.hello_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public User createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("ErrorCode.USER_EXISTED");

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return  userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);

        userMapper.updateUser(user, request);

       return userRepository.save(user);
    }


    public void deleteUser(String userId){
        User user = userRepository.findById(userId).orElseThrow( () -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not found"));

    }


}
