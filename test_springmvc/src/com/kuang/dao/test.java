package com.kuang.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx
		=new ClassPathXmlApplicationContext("spring.xml");
			JdbcTemplate jdbc=(JdbcTemplate)ctx.getBean("jdbc");
			jdbc.execute("create table account(id int primary key auto_increment,"
					    +"username varchar(30),balance double)");
			System.out.println("account表创建成功");
	}

}
