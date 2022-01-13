package com.kuang.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kuang.entity.UserBean;
@Component
public class UserDao implements UserDaoInterface{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<UserBean> selectAll() {
		System.out.println(this.jdbcTemplate);
		String sql = "select * from tb_user";
		RowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
		return this.jdbcTemplate.query(sql, rowMapper);	
	}
	
}
