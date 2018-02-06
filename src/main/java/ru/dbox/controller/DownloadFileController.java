package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import ru.dbox.model.FileEntity;
import ru.dbox.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownloadFileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public StreamingResponseBody downloadFile(HttpServletResponse response, @Param("id") int id) throws IOException {
        FileEntity entity = fileService.getFileById(id);
        File downloadFile = new File("C:\\ShareFolder\\" + entity.getFile_name() + "");
        FileInputStream inputStream = new FileInputStream(downloadFile);

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + entity.getFile_name() + "";
        response.setHeader(headerKey, headerValue);

        return (OutputStream outputStream) -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
        };
    }
}