package com.platformance.wdt.web.mvc.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserListMapper {
    List<Map<String, Object>> selectTest();
}