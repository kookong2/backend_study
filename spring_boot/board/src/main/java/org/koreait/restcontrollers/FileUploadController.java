package org.koreait.restcontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file/upload")
public class FileUploadController {

    @PostMapping
    public void upload(MultipartFile[] files){
        System.out.println(files);
    }

}
