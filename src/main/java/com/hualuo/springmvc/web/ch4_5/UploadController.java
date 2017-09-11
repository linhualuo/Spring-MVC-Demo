package com.hualuo.springmvc.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 上传文件控制器
 *
 * @author Joseph
 * @create 2017/9/11 14:09
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) {
        try {
            FileUtils.writeByteArrayToFile(new File("e:/upload/" + file.getOriginalFilename()), file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
