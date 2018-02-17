package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.dbox.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;
}
