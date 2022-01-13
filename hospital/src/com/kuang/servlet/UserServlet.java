package com.kuang.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kuang.entity.User;
import com.kuang.service.UserService;

@WebServlet("/user")
public class UserServlet extends BaseServlet{
	UserService userService=new UserService();
	//验证用户名是否被注册过
	public void checkUserName(HttpServletRequest request,HttpServletResponse response) {		
		//获取用户名
		String username=request.getParameter("username");
		//调用service层的方法来验证
		boolean flag=userService.checkUserName(username);
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//验证邮箱是否被注册过
		public void checkEmail(HttpServletRequest request,HttpServletResponse response) {
			UserService userService=new UserService();
			//获取邮箱
			String email=request.getParameter("email");
			//调用service层的方法来验证
			boolean flag=userService.checkEmail(email);
			try {
				response.getWriter().print(flag);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//注册功能
		public void regist(HttpServletRequest request,HttpServletResponse response) {
			//从jsp页面获取数据
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			//构造用户对象
			User user=new User(name,email,1,username,password,new Date());
			//调用service层的添加方法完成注册功能
			boolean flag=userService.insertUser(user);
			if(flag) {
				//System.out.println("注册成功");
				//跳转至登录页面
				try {
					response.sendRedirect("login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					response.sendRedirect("regist.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//检查验证码是否正确
		public void checkverifyCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
			String verifyCode=request.getParameter("verifyCode");
			//获取session中事先保存好的验证码
			HttpSession session = request.getSession();//ctrl+2+L快速生成表达式的变量
			String verCode = (String)session.getAttribute("verCode");
			boolean flag=false;
			if(verifyCode.equalsIgnoreCase(verCode)) {
				//相等表示验证通过
				flag=true;
			}
			response.getWriter().print(flag);
		}
		//验证用户名和密码
		public void checkLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
			//获取页面的用户名和密码
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			boolean flag=userService.checkLogin(username,password,request.getSession());
			if(flag) {
				//登录成功进入系统后台主页
				response.sendRedirect("index.jsp");
			}else {
				//登录失败重新登录
				response.sendRedirect("login.jsp");
			}
		}
		//退出的回调
				public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
					//清空session
					request.getSession().invalidate();
					//返回登录界面
					response.sendRedirect("login.jsp");
				}
}
