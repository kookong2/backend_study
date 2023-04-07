package org.koreait.controllers.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/file/upload")
public class FileUploadController {
    @Value("${fileupload.path}")
    private String uploadPath;

    @GetMapping
    public String upload(){

        return "file/upload";
    }

    @PostMapping
    @ResponseBody
    public void uploadPs(MultipartFile[] files){
        Arrays.stream(files).forEach(file -> {
            String fileName = file.getOriginalFilename();
            File f = new File(uploadPath + File.separator + fileName);
            try {
                file.transferTo(f);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
