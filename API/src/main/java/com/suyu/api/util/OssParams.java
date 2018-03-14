package com.suyu.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zwd
 * @date 2018/3/14 08:25
 */
    @Component(value = "ossParams")
    public class OssParams {

        @Value("${aliyun.oss.accessKeyId}")
        private String accessKeyId;

        @Value("${aliyun.oss.accessKeySecret}")
        private String accessKeySecret ;

        @Value("${aliyun.oss.endpoint}")
        private String endpoint;

        @Value("${aliyun.oss.Bucket}")
        private String Bucket;

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getBucket() {
            return Bucket;
        }

        public void setBucket(String bucket) {
            Bucket = bucket;
        }

        @Override
        public String toString() {
            return "OssParams{" +
                    "accessKeyId='" + accessKeyId + '\'' +
                    ", accessKeySecret='" + accessKeySecret + '\'' +
                    ", endpoint='" + endpoint + '\'' +
                    ", Bucket='" + Bucket + '\'' +
                    '}';
        }

        public OssParams() {
        }
    }
