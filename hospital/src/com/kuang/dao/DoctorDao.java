package com.kuang.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kuang.entity.Doctor;
import com.kuang.utils.PageTool;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DoctorDao {
	QueryRunner queryRunner=new QueryRunner(new ComboPooledDataSource());
	
	//分页查询
	public List<Doctor> findDoctorByPage(PageTool pageTool){
		String sql="select * from doctor limit ?,?";
		try {
			return queryRunner.query(sql, new BeanListHandler<Doctor>(Doctor.class),pageTool.getStartIndex(),pageTool.getPageSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//查询医生表中记录的总条数
	public int getTotalCount() {
		String sql="select count(*) from doctor";
		int count=0;
		try {
			Long l=(Long)queryRunner.query(sql, new ScalarHandler());
			count=l.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
