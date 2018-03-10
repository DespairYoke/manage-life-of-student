package cc.huluwa.util;

import cc.huluwa.config.Config;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Component
public class MessageSend {
    /**
     * 发送短信的方法
     *
     * @param phone
     * @param code
     * @return
     */
    public static boolean sendMsg(String phone, String code) {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(Config.url);
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data = {
                new NameValuePair("corp_id", Config.corp_idcorp_id),
                new NameValuePair("corp_pwd", Config.corp_pwd),
                new NameValuePair("corp_service", Config.corp_service),
                new NameValuePair("mobile", phone),
                new NameValuePair("msg_content", Config.content_before + code + Config.content_end),
                new NameValuePair("corp_msg_id ", UUID.randomUUID().toString()),
                new NameValuePair("ext ", Config.ext)
        };
        post.setRequestBody(data);
        Boolean x = getaBoolean(client, post);
        if (x != null) return x;
        return false;
    }

    /**
     * 短信群发
     *
     * @param listPhone
     * @param content
     * @return
     */
    public static int send_cat(List<String> listPhone, String content) {
        StringBuffer sb = new StringBuffer();
        int total = 0;
        for (String phone : listPhone) {

            sb.append(phone);
            sb.append(Config.split);
            sb.append(Config.corp_msg_id);
            sb.append(Config.split);
            sb.append(Config.ext);
            sb.append(Config.split);
            if (listPhone.size() == total + 1) {
                sb.append(content);
            } else {
                sb.append(content + Config.group);
            }
            total++;
        }
        int result = -1;
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Config.many_url);
        method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
        try {
            System.out.println(sb.toString());
            System.out.println(total);
            method.addParameter("corp_id", Config.corp_idcorp_id);
            method.addParameter("corp_pwd", Config.corp_pwd);
            method.addParameter("corp_service", Config.corp_service);
            method.addParameter("total_count", total + "");
            method.addParameter("send_param", sb.toString());
            method.addParameter("ctrl_param", Config.ctrl_param + "");
            client.executeMethod(method);
            String sendResult = method.getResponseBodyAsString();
            System.out.println("=============" + sendResult);
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        } finally {
            try {
                method.releaseConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static boolean pastDue(String phone, String code) {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(Config.url);
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data = {
                new NameValuePair("corp_id", Config.corp_idcorp_id),
                new NameValuePair("corp_pwd", Config.corp_pwd),
                new NameValuePair("corp_service", Config.corp_service),
                new NameValuePair("mobile", phone),
                new NameValuePair("msg_content", code),
                new NameValuePair("corp_msg_id ", UUID.randomUUID().toString()),
                new NameValuePair("ext ", Config.ext)
        };
        post.setRequestBody(data);
        Boolean x = getaBoolean(client, post);
        if (x != null) return x;
        return false;
    }

    public static boolean pastDate(String phone, String code) {
        HttpClient httpclient = new HttpClient();
        PostMethod postMethod = new PostMethod(Config.url);
        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
        NameValuePair[] date = {
                new NameValuePair("corp_id", Config.corp_idcorp_id),
                new NameValuePair("corp_pwd", Config.corp_pwd),
                new NameValuePair("corp_service", Config.corp_service),
                new NameValuePair("mobile", phone),
                new NameValuePair("msg_content", code),
                new NameValuePair("corp_msg_id ", UUID.randomUUID().toString()),
                new NameValuePair("ext ", Config.ext)
        };
        postMethod.setRequestBody(date);
        Boolean y = getaBoolean(httpclient, postMethod);
        if (y != null) {
            return y;
        }
        return false;
    }

    private static Boolean getaBoolean(HttpClient client, PostMethod post) {
        try {
            client.executeMethod(post);
            int statusCode = post.getStatusCode();
            if (statusCode == 200) {

                String result = new String(post.getResponseBodyAsString());
                post.releaseConnection();
                if (result.indexOf("0#") != -1) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询余额的方法
     *
     * @return
     */
    public static String getBanlance() {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(Config.url);
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data = {
                new NameValuePair("corp_id", Config.corp_idcorp_id),
                new NameValuePair("corp_id", Config.corp_idcorp_id),
                new NameValuePair("user_id", Config.corp_idcorp_id),
                new NameValuePair("corp_pwd", Config.corp_pwd)
        };
        post.setRequestBody(data);
        try {
            client.executeMethod(post);
            int statusCode = post.getStatusCode();
            if (statusCode == 200) {
                String result = new String(post.getResponseBodyAsString());
                if (result.indexOf("ok#") != -1) {

                    return result.replace("ok#", "");
                }
            }
            post.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
