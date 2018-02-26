package com.alibaba;

import com.alibaba.domain.User;
import com.alibaba.domain.UserTask;
import com.alibaba.mapper.UserMapper;
import com.alibaba.mapper.UserTaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 * @author zwd
 * @date 2018/1/16 14:45
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes =App.class)
public class mpp {

    @Autowired
    private UserTaskMapper userTaskMapper;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }

//    @Test
//    public void test2(){
//        UserTask userTask = new UserTask();
//        for (int i=0;i<100;i++)
//        {
//            userTask.setUser_id(i+1);
//            userTask.setSonday(0);
//            userTask.setMonday(0);
//            userTask.setTuesday(0);
//            userTask.setWednesday(0);
//            userTask.setToursday(0);
//            userTask.setFriday(0);
//            userTask.setSaturday(0);
//            userTaskMapper.insertSelective(userTask);
//        }
//
//    }

    @Test
    public void test3() throws NoSuchAlgorithmException {
        User userTask = new User();
        for (int i=0;i<100;i++)
        {
            if (i<10){
                userTask.setNumber("0"+i+1);
            }
            else {
                userTask.setNumber(i +"");
            }
            MessageDigest sha = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder =new BASE64Encoder();
            String password = base64Encoder.encode(sha.digest("123456".getBytes()));
            userTask.setPassword(password);
            userMapper.insert(userTask);
        }

    }
}
