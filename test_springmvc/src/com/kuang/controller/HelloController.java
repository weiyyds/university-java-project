package com.kuang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuang.dao.UserDao;
import com.kuang.entity.UserBean;

@RestController
public class HelloController {
	@Autowired
	UserDao userDao;
	@GetMapping("/hello")
	public String hello() {
		return "helllo word";
	}
	@GetMapping("/find")
	public List<UserBean> findAllUser(){
		System.out.println("userDao"+userDao);
		//return userDao.findAllUser();
		return userDao.selectAll();
	}
}
