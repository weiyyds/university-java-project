package com.kuang.dao;

import java.util.List;

import com.kuang.entity.UserBean;

public interface UserDaoInterface {
	public List<UserBean> selectAll();
}
