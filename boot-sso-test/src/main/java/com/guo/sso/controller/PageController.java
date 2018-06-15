package com.guo.sso.controller;

import com.guo.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@Autowired
	UserService userService;

	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex() {
		System.out.println("ssotest go index");
		return "/index";
	}
	
	@RequestMapping("/github/{page}")
	public String showpage(@PathVariable String page) {
		System.out.println("ssotest go page:" + page);
		return "/"+page;
	}
}
