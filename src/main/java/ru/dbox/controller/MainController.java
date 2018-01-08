package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dbox.service.FileService;
import ru.dbox.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("files", fileService.getAllFiles());
        return "main";
    }

//    @RequestMapping(value = "/uploadPage", method = RequestMethod.GET)
//    public String upload (Model model) {
//        model.addAttribute("filesUpload");
//        return "uploadPage";
//    }
}