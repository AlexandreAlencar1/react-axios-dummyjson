package com.example.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dtos.UserRecordDto;
import com.example.springboot.models.UserModel;
import com.example.springboot.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel saveUser(UserRecordDto userRecordDto) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return userRepository.save(userModel);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long idUser) { // Atualizado para idUser
        return userRepository.findById(idUser);
    }

    public UserModel updateUser(Long idUser, UserRecordDto userRecordDto) { // Atualizado para idUser
        Optional<UserModel> optionalUser = userRepository.findById(idUser);
        if (optionalUser.isPresent()) {
            UserModel userModel = optionalUser.get();
            BeanUtils.copyProperties(userRecordDto, userModel);
            return userRepository.save(userModel);
        }
        return null;
    }

    public void deleteUser(Long idUser) { // Atualizado para idUser
        userRepository.deleteById(idUser);
    }
}
