package com.ifms.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifms.spring.model.User;
import com.ifms.spring.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user/";
    }

    // ----------------------------------------------------------------
    @GetMapping("/")
    public String locAll(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index.html";
    }

    // ----------------------------------------------------------------
    @GetMapping("/cadastrar")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "cadastrar.html";
    }

    // ----------------------------------------------------------------
    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        log.info("id =" + id);
        userService.delete(id);
        return "redirect:/user/";
    }

    @GetMapping("/editt/{id}")
    public User updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        // log.info("user pwd = " + user.getPassword());
        return user;
    }

    // ----------------------------------------------------------------
    // para chamar a página de edit-student.html
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {

        User user = userService.findById(id);
        // log.info("user pwd = " + user.getPassword());

        model.addAttribute("user", user);

        return "edit-student";
    }

    // ----------------------------------------------------------------
    // Aqui chamamos a func update para salvar no bd
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user, Model model) {

        userService.updateUser(user);

        return "redirect:/user/";
    }
}