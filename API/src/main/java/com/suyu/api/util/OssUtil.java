package com.suyu.api.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

/**
 * @author zwd
 * @date 2018/3/14 08:37
 */
@Component
public class OssUtil {
    @Autowired
    private OssParams ossParams;

    private OSSClient ossClient = null;

    private void connect() {
        System.out.println(ossParams);
        ossClient = new OSSClient(ossParams.getEndpoint(), ossParams.getAccessKeyId(), ossParams.getAccessKeySecret());
    }

    private static OssUtil ossUtil;

    /**
     * OssUtil ossUtil = new OssUtil();
     * ossUtil.uploadFile("test/test2.docx" , new File("./data/test0.docx"));
     *
     * @param key
     * @param inputStream
     */
    public void upload(InputStream inputStream, String key) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.putObject(ossParams.getBucket(), key,inputStream);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }

    /**
     * OssUtil ossUtil = new OssUtil();
     * ossUtil.uploadFile(map);
     *
     * @param map key:oss的key    value:上传的文件对象
     */
    public void uploadManyFile(Map<String, File> map) {
        if (ossClient == null) {
            connect();
        }
        try {
            for (String key : map.keySet()) {
                ossClient.putObject(ossParams.getBucket(), key, map.get(key));
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
//            ossClient.shutdown();
//            ossClient = null;
        }
    }
}
