package com.wei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/123")
public class test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("成功");
		String number=(String) req.getParameter("number");
		String pwd=(String) req.getParameter("pwd");
		String input_code=(String)req.getParameter("input_code");
		HttpSession session_code=(HttpSession) req.getSession();
		Object value=session_code.getAttribute("piccode");
		if(input_code.equals(value)) {
			resp.sendRedirect("/help/main.html");
		}
		
	}
	

}
