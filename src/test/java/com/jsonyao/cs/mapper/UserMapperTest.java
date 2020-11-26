package com.jsonyao.cs.mapper;

import com.jsonyao.cs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void findById(){
        Long id = 1000l;
        User user = userMapper.findById(id);
        System.out.println(user.toString());
    }
}