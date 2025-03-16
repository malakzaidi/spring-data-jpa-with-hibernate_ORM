package org.springdata.project2_many_to_many_use_case.Controllers;

import org.springdata.project2_many_to_many_use_case.entities.User;
import org.springdata.project2_many_to_many_use_case.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username) {
        User user = userService.findUserByUserName(username);
        return user;

    }
}
