package com.guo.bootspringdata.dao;

import com.guo.bootspringdata.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testadd() {
    }

    @Test
    public void test1() {
        User user = userRepository.getUserById(1);
        System.out.println(user);
    }

}