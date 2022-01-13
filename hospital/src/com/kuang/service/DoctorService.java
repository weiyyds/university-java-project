package com.kuang.service;
import java.util.List;

import com.kuang.dao.DoctorDao;
import com.kuang.entity.Doctor;
import com.kuang.utils.PageTool;
public class DoctorService {
		DoctorDao doctorDao=new DoctorDao();
			//分页查询
			public List<Doctor> findDoctorByPage(PageTool pageTool){
				return doctorDao.findDoctorByPage(pageTool);
			}
			//查询医生表中记录的总条数
			public int getTotalCount() {
				return doctorDao.getTotalCount();
	}

}
	