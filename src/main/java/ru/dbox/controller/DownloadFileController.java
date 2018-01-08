package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.dbox.service.FileService;

public class DownloadFileController {
    @Autowired
    private FileService fileService;

}
