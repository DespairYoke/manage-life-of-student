package com.suyu.api.controller;//package com.alibaba.controller;


import com.alibaba.fastjson.JSON;
import com.suyu.api.domain.FileUpLoad;
import com.suyu.api.domain.Image;
import com.suyu.api.domain.User;
import com.suyu.api.service.FileUpLoadService;
import com.suyu.api.service.ImageService;
import com.suyu.api.util.InfoCode;
import com.suyu.api.util.OssUtil;
import com.suyu.api.util.RespInfo;
import com.suyu.mail.server.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
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
    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */
    @Value("${zwd.img.path}")
    private  String URL;

    private final String FILEURL = "/usr/local/file/";
    @Autowired
    private ImageService imageService;
    @Autowired
    private FileUpLoadService fileUpLoadService;
    @Autowired
    private MailService mailService;
    @Autowired
    private OssUtil ossUtil;

    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file",required = false) MultipartFile file,Integer id) throws Exception {
        RespInfo respInfo = new RespInfo();
        String fileName = "";
        if (!file.isEmpty()) {
            fileName = file.getOriginalFilename();
            String type = fileName.substring(fileName.lastIndexOf("."));
            if (Arrays.asList(types).contains(type)){

            BufferedOutputStream out = null;
            fileName = file.getOriginalFilename();
            LOGGER.info("上传的文件名为：" + fileName);
            fileName=new Date().getTime()+"";
            ossUtil.upload(file.getInputStream(),URL+fileName+type);
            Image image = new Image();
            image.setUserid(id);
            image.setUrl("http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/"+URL+fileName+type);
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
                String name = fileName;
                LOGGER.info("上传的文件名为：" + fileName);
                fileName=new Date().getTime()+"";
                ossUtil.upload(file.getInputStream(),URL+fileName+type);
                FileUpLoad file1 = new FileUpLoad();
                file1.setUserid(id);
                file1.setTitle(name);
                file1.setUrl("http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/"+URL+fileName+type);
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
    @RequestMapping(value = "findimage")
    public String findAllImage(@RequestBody User user) {
        RespInfo respInfo = new RespInfo();
        List<Image> list = imageService.selectMyAllImage(user.getId());
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
    @RequestMapping(value = "sendemail")
    public String test(){
        mailService.sendSimpleMail("lighAsqh@163.com", "test", "hello world");
        return "hello world";
    }
}
