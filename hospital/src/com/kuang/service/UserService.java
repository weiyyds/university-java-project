package com.kuang.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.kuang.dao.UserDao;
import com.kuang.entity.User;

public class UserService {
	UserDao userDao=new UserDao();
	//根据用户名查询
	public boolean checkUserName(String username) {
		User user=userDao.checkUserName(username);
		if(user!=null){
			return true;//表示该用户名在表中被注册过了
		}
		return false;
	}
	//根据邮箱查询
	public boolean checkEmail(String email) {
		User user=userDao.checkEmail(email);
		if(user!=null){
			return true;//表示该邮箱在表中被注册过了
		}
		return false;
	}
	//添加用户
		public boolean insertUser(User user) {
			int r=userDao.insertUser(user);
			if(r>0) {
				return true;
			}else {
				return false;
			}
			
		}
		public boolean checkLogin(String username, String password,HttpSession session) {
			User user=userDao.checkLogin(username,password);
			if(user!=null) {
				session.setAttribute("user", user);
				return true;
			}else {
				return false;
			}
		}


}
