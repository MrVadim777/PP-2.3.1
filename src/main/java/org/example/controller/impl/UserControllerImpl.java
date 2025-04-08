package org.example.controller.impl;

import org.example.controller.UserController;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @Override
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("/save")
    @Override
    public String save(@Valid @ModelAttribute("user") User user,
                       BindingResult exResult,
                       Model model) {

        if (exResult.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            model.addAttribute("errors", exResult);
            return "users";
        }

        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    @Override
    public String update(@Valid @ModelAttribute("user") User user,
                         BindingResult exResult,
                         Model model) {

        if (exResult.hasErrors()) {
            model.addAttribute("errors", exResult);
            return "edit";
        }

        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        User user = userService.find(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/delete")
    @Override
    public String deleteById(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
