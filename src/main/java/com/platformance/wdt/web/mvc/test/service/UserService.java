package com.platformance.wdt.web.mvc.test.service;

import com.platformance.wdt.web.mvc.test.mapper.UserListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {
    @Autowired
    UserListMapper userMapper;

    public List<Map<String, Object>> selectTest() {
        return userMapper.selectTest();
    }
}
