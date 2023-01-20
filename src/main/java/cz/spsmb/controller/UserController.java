package cz.spsmb.controller;

import cz.spsmb.entity.User;
import cz.spsmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/userSignUp", method = RequestMethod.POST)
    public void singUpUser(@RequestParam String name, @RequestParam String password) {
        System.out.println(name);
        System.out.println(password);
        this.userService.signUpUser(name, password);
    }

    @RequestMapping(path = "/user/{userName}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String userName) {
        return this.userService.getUserByName(userName);
    }
}
