package com.guo.bootspringdata.dao;

import com.guo.bootspringdata.pojo.User;
import com.guo.bootspringdata.service.IUserService;
import com.guo.bootspringdata.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;


    @Test
    public void testCreit(){

        //Sort sort = ;



        //Specification<User> tSpecification = null;


        //userRepository.findAll(tSpecification, sort);
    }

    @Test
    public void testOptimis() {
        User user = userService.getUserById(1);
        System.out.println("Got user: " + user);
        //userService.updateUserEmailById(user.getId(), "A@qq.com");
        //开启线程A修改
        //new Thread(new MyThread(user), "aa").start();
        //开启线程B修改
        //new Thread(new MyThread(user), "bb").start();

    }

    class MyThread implements Runnable {

        private User user;

        public MyThread(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            try {
                User user1 = userService.getUserById(1);
                System.out.println("Got user: " + user1);

                String name = Thread.currentThread().getName();
                if ("aa".equals(name)) {
                    Thread.sleep(200);
                }
                System.out.println("Thread Name:" + name + ", email:" + user1.getEmail());
                //userService.updateUserEmailById(user1.getId(), name + "@qq.com");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 增加
     */
    @Test
    public void testadd() {
        User user = new User();
        user.setAccount("account0");
        user.setPassword("bb123456");
        userRepository.save(user);
        user.setEmail("1161588342");
    }

    /**
     * 删除
     */
    @Test
    public void testdel() {
        User user = new User();
        user.setId(2);
        userRepository.delete(user);
    }

    /**
     * 改 需要进过事物处理
     */
    @Test
    public void testupd() {
        userService.updateUserEmailById(1, "guominghua@gmail.com");
    }


    /**
     * 查询
     */
    @Test
    public void test1() {
        User user = userRepository.getUserById(1);
        System.out.println(user);
    }

}