package com.kuang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuang.entity.Doctor;
import com.kuang.service.DoctorService;
import com.kuang.utils.PageTool;

@WebServlet("/doctor")
public class DoctorServlet extends BaseServlet{
	DoctorService doctorService=new DoctorService();
	//分页查询
	public void findDoctorByPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{ 
		//1.获取总记录数
		int totalCount=doctorService.getTotalCount();
		//2.当前页码从页面获取
		String currentPage = request.getParameter("currentPage");
		//封装分页查询的工具类
		PageTool pageTool=new PageTool(totalCount,currentPage);
		//调用service层中的方法
		List<Doctor> doctorList = doctorService.findDoctorByPage(pageTool);
		System.out.println(doctorList);
		//将数据保存到域对象
		request.setAttribute("pageTool", pageTool);
		request.setAttribute("doctorList",doctorList);
		//转发到医生的index.jsp页面
		request.getRequestDispatcher("doctor/index.jsp").forward(request, response);
		
	}
}
