package com.alibaba;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zwd
 * @date 2018/1/17 14:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class Test1 {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws Exception {

//        // 保存字符串
      ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("aaa","111");
//        Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));
          stringRedisTemplate.opsForValue().set("bbb","2222");
        System.out.println(stringRedisTemplate.opsForValue().get("bbb"));
    }
}
