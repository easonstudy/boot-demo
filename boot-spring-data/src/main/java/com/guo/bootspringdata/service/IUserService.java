package com.guo.bootspringdata.service;

import com.guo.bootspringdata.pojo.User;

public interface IUserService {
    public void updateUserEmailById(Integer id, String email);
    public User getUserById(Integer id);
}
