package com.ljl.zhsx.controller;

import com.ljl.zhsx.service.OssService;
import com.ljl.zhsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author L.J.L
 * @qq 963314043
 * @date 2022/6/13 21:48
 */
@CrossOrigin
@RestController
@RequestMapping("/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;

    //上传头像
    @PostMapping("/upload")
    public Result uploadOssFile(@RequestParam("file") MultipartFile file){
        //获取上传的文件

        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);

        //返回r对象
        return Result.ok().data("url",url).message("文件上传成功");
    }

}
