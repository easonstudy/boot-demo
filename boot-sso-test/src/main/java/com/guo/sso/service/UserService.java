package com.guo.sso.service;


import com.guo.sso.pojo.User;

public interface UserService {
	
	User getUserByToken(String token);
	
}
