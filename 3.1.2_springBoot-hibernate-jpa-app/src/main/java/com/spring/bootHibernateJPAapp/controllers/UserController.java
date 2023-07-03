package com.spring.bootHibernateJPAapp.controllers;

import com.spring.bootHibernateJPAapp.models.User;
import com.spring.bootHibernateJPAapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String getNewUserForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String getUpdateUserForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUserById(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                                 @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "update";

        userService.updateUserById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String removeUserById(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";

    }

}
