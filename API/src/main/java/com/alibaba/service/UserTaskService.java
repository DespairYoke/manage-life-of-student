package com.alibaba.service;

import java.util.List;
import java.util.Map;

/**
 * @author zwd
 * @date 2018/2/28 16:35
 */
public interface UserTaskService {
    List<Map> selectByDay(String day);
}
