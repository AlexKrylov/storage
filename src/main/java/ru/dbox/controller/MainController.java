package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dbox.service.FileService;

@Controller
public class MainController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/main")
    public String mainPage(Model model) {
        model.addAttribute("files", fileService.getAllFiles());
        return "main";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String registerPage() {
        return "register";
    }
}