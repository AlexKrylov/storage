package ru.dbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dbox.model.FileEntity;
import ru.dbox.service.FileService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.springframework.util.StreamUtils.BUFFER_SIZE;

public class DownloadFileController {
    @Autowired
    private FileService fileService;
    
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void doDownload(@RequestParam("id") String url, HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        FileEntity entity = fileService.getFileByUrl(url);

        String pathFiles = "C:\\ShareFolder";
        String fullPath = pathFiles + "/" + entity.getFile_name();

        ServletContext context = request.getServletContext();

        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", entity.getFile_name());
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();
    }
}
