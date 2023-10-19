package com.exceptionhandling.service;

import com.exceptionhandling.dto.UserRequest;
import com.exceptionhandling.entity.User;
import com.exceptionhandling.exception.ResourceNotFoundException;
import com.exceptionhandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){

        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());

       return userRepository.save(user);
    }

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public User getUser(int userId) throws ResourceNotFoundException {

        User user = userRepository.findByUserId(userId);
        if(user!=null){
            return user;
        }else {
            throw new ResourceNotFoundException("User not found for ID : " + userId);
        }

    }
}
