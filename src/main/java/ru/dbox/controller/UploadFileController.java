package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;
import ru.dbox.model.FileEntity;
import ru.dbox.service.FileService;
import ru.dbox.service.UserService;
import ru.dbox.utils.Generator;

import javax.xml.crypto.Data;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;

@Controller
public class UploadFileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String FileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String fileName = file.getOriginalFilename();
                if (fileName != null) {
                    fileService.addFile(new FileEntity(file.getOriginalFilename(), Generator.generateUrl(), 1, DateUtils.createNow()));
                    File dir = new File("C:\\ShareFolder");
                    if (!dir.exists())
                        dir.mkdirs();
                    File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.flush();
                    stream.close();
                }
                return "Вы успешно загрузили файл";
            } catch (Exception e) {
                return "Вам не удалось загрузить файл " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить файл, потому что файл пустой.";
        }
    }
}
