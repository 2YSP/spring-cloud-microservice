package cn.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ship
 * @Description 文件上传
 * @Date: 2018-07-24 09:43
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file",required = true) MultipartFile file)throws IOException{
        File desFile = new File(file.getOriginalFilename());
        FileCopyUtils.copy(file.getBytes(),desFile);
        return desFile.getAbsolutePath();
    }
}
