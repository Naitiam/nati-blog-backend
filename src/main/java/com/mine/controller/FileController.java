package com.mine.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {
    @Value("${files.upload.path}")
    private String fileUploadPath;
    @PostMapping("/upload")
    public String fileupload(@RequestParam MultipartFile file) throws IOException {
//        System.out.println(fileUploadPath);
        String originalFileName = file.getOriginalFilename();
        File f = new File(fileUploadPath);
        f.mkdirs();
        String uuid = UUID.randomUUID().toString();
        String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
        file.transferTo(new File(fileUploadPath+newFileName));
//        String imgurl ="/img/"+newFileName;
//        System.out.println(imgurl);
        return "http://localhost:9090/img/"+newFileName;
    }
}
