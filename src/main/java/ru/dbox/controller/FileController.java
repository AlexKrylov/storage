package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dbox.model.FileEntity;
import ru.dbox.service.FileService;

import java.io.File;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    public @ResponseBody
    @RequestMapping(value = "/delete_file", method = RequestMethod.GET)
    String deleteFile(@Param("id") int id) {
        FileEntity entity = fileService.getFileById(id);
        fileService.deleteFileById(id);
        File removableFile = new File("C:\\ShareFolder\\" + entity.getFile_name() + "");
        if (removableFile.delete()) {
            return "Файл успешно удален";
        } else {
            return "Ошибка";
        }
    }
}
