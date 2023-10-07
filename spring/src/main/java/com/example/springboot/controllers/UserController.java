package com.example.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dtos.UserRecordDto;
import com.example.springboot.models.UserModel;
import com.example.springboot.services.UserService;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin("localhost:3000")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping // Salvar usuário // public ResponseEntity<?> significa que ele pode retornar qualquer tipo de objeto ou nenhuma informação pq tava dando conflito 
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        if (userRecordDto.getName() == null || userRecordDto.getEmail() == null || userRecordDto.getPassword() == null) {
            return ResponseEntity.badRequest().body("Campos obrigatórios não preenchidos");
        }
        if (userService.isEmailAlreadyRegistered(userRecordDto.getEmail())) {
            return ResponseEntity.badRequest().body("O email já está cadastrado");
        }
    
        UserModel userModel = userService.saveUser(userRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }
    

    @GetMapping // Consultar todos os usuários
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> userList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/user/{idUser}") // Consultar por ID
    public ResponseEntity<Object> getUserById(@PathVariable Long idUser) {
        Optional<UserModel> userOptional = userService.getUserById(idUser);
        if (userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @PutMapping("/user/{idUser}") // Atualizar por ID
    public ResponseEntity<Object> updateUser(@PathVariable Long idUser, @RequestBody @Valid UserRecordDto userRecordDto) {
        UserModel updatedUser = userService.updateUser(idUser, userRecordDto);
        if (updatedUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @DeleteMapping("/user/{idUser}") // Deletar por ID
    public ResponseEntity<Object> deleteUser(@PathVariable Long idUser) {
        userService.deleteUser(idUser);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }
}
