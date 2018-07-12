package com.guo.bootspringdata.service;

import com.guo.bootspringdata.dao.UserRepository;
import com.guo.bootspringdata.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void updateUserEmailById(Integer id, String email){
        userRepository.updateUserEmail(id, email);
    }

    public User getUserById(Integer id){
        return userRepository.getUserById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }




}
