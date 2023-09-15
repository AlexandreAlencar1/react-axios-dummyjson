package com.ifms.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.spring.model.User;

@Service

public class UserService {

    @Autowired
   com.ifms.spring.repository.UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
    
    public void updateUser(User user){
        userRepository.save(user);
    }

    
}
