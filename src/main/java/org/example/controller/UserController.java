package org.example.controller;

import org.example.model.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface UserController{
    String getAll(Model model);
    String save(User user, BindingResult result, Model model);
    String update(User user, BindingResult result, Model model);
    String deleteById(Long id);
}
