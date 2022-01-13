package com.kuang.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kuang.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDao {
	QueryRunner qRunner=new QueryRunner(new ComboPooledDataSource());
	//根据用户名查询用户对象
	public User checkUserName(String username) {
		String sql ="select * from users where username =?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据邮箱查询用户对象
	public User checkEmail(String email) {
		String sql ="select * from users where email =?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class),email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//添加用户
	public int insertUser(User user) {
		String sql="insert into users (name,email,status,username,password,modifytime) values (?,?,?,?,?,?)";
		try {
			return qRunner.update(sql,user.getName(),user.getEmail(),user.getStatus(),user.getUsername(),user.getPassword(),user.getModifytime());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	//根据用户名和密码查询对象
	public User checkLogin(String username, String password){
		String sql="select * from users where username =? and password =? and status =1";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
