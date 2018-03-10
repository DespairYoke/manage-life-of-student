package com.alibaba.controller;

import com.alibaba.Util.InfoCode;
import com.alibaba.Util.RespInfo;
import com.alibaba.domain.FileUpLoad;
import com.alibaba.domain.Image;
import com.alibaba.domain.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.service.FileUpLoadService;
import com.alibaba.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author zwd
 * @date 2018/3/9 14:19
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadImgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadImgController.class);

    /**支持图片的类型**/
    private String [] types={".jpg",".bmp",".jpeg",".png"};

    private String [] fileType = {".docx",".doc",".excel",".pdf"};
    private final String PATH = "img";
    private final String FILEPATH = "file";
    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */

    private final String URL = "/Users/zwd-admin/company/API/manage-life-of-student/img/";

    private final String FILEURL = "/Users/zwd-admin/company/API/manage-life-of-student/file/";
    @Autowired
    private ImageService imageService;
    @Autowired
    private FileUpLoadService fileUpLoadService;

    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file",required = false) MultipartFile file,Integer id) throws Exception {
        RespInfo respInfo = new RespInfo();
        String fileName = "";
        if (!file.isEmpty()) {
            fileName = file.getOriginalFilename();
            String type = fileName.substring(fileName.lastIndexOf("."));
            if (Arrays.asList(types).contains(type)){

            BufferedOutputStream out = null;
            File fileSourcePath = new java.io.File(PATH);
            if (!fileSourcePath.exists()) {
                fileSourcePath.mkdirs();
            }
            fileName = file.getOriginalFilename();
            LOGGER.info("上传的文件名为：" + fileName);
            fileName=new Date().getTime()+fileName;
            out = new BufferedOutputStream(
                    new FileOutputStream(new File(fileSourcePath, fileName)));
            out.write(file.getBytes());
            out.flush();
            Image image = new Image();
            image.setUserid(id);
            image.setUrl(URL+fileName);
            imageService.insertExample(image);
            System.out.println(fileName.toString());
            respInfo.setStatus(InfoCode.SUCCESS);
            respInfo.setContent(image.getUrl());
            respInfo.setMesssage("上传成功！");
            return JSON.toJSONString(respInfo);
        }
        respInfo.setMesssage("此格式不支持！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
        }
        respInfo.setMesssage("文件不能为空！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }
    @RequestMapping(value = "file",method = RequestMethod.POST)
    public String uploadfile(@RequestParam(value = "file",required = false) MultipartFile file,Integer id) throws Exception {
        RespInfo respInfo = new RespInfo();
        String fileName = "";
        if (!file.isEmpty()) {
            fileName = file.getOriginalFilename();
            String type = fileName.substring(fileName.lastIndexOf("."));
            if (Arrays.asList(fileType).contains(type)){

                BufferedOutputStream out = null;
                File fileSourcePath = new File(FILEPATH);
                if (!fileSourcePath.exists()) {
                    fileSourcePath.mkdirs();
                }
                fileName = file.getOriginalFilename();
                String name = fileName;
                LOGGER.info("上传的文件名为：" + fileName);
                fileName=new Date().getTime()+fileName;
                out = new BufferedOutputStream(
                        new FileOutputStream(new File(fileSourcePath, fileName)));
                out.write(file.getBytes());
                out.flush();
                FileUpLoad file1 = new FileUpLoad();
                file1.setUserid(id);
                file1.setTitle(name);
                file1.setUrl(FILEURL+fileName);
                fileUpLoadService.insertExample(file1);
                System.out.println(fileName.toString());
                respInfo.setStatus(InfoCode.SUCCESS);
                respInfo.setContent(file1.getUrl());
                respInfo.setMesssage("上传成功！");
                return JSON.toJSONString(respInfo);
            }
            respInfo.setMesssage("此格式不支持！");
            respInfo.setStatus(InfoCode.FAIL);
            return JSON.toJSONString(respInfo);
        }
        respInfo.setMesssage("文件不能为空！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "findfile")
    public String findAllFile(@RequestBody User user) {
        RespInfo respInfo = new RespInfo();
        List<FileUpLoad> list = fileUpLoadService.selectMyAllFile(user.getId());
        if (!list.isEmpty()) {
            respInfo.setMesssage("查询成功");
            respInfo.setContent(list);
            respInfo.setStatus(InfoCode.SUCCESS);
            return JSON.toJSONString(respInfo);
        } else {
            respInfo.setMesssage("你的列表为空");
            respInfo.setStatus(InfoCode.FAIL);
            return JSON.toJSONString(respInfo);
        }

    }
}
