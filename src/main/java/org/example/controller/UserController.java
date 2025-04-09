package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.example.validation.ValidationOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("/save")
    public String save(@Validated(ValidationOrder.class) @ModelAttribute("user") User user,
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
    public String update(@Validated(ValidationOrder.class) @ModelAttribute("user") User user,
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
    public String deleteById(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
