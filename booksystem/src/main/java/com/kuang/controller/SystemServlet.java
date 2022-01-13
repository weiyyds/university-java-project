package com.kuang.controller;

import com.kuang.dao.AdminDao;
import com.kuang.dao.StudentDao;
import com.kuang.dao.TeacherDao;
import com.kuang.entity.Admin;
import com.kuang.entity.Student;
import com.kuang.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/SystemServlet")
public class SystemServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -7258264317769166483L;

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String method = request.getParameter("method");
        if("toPersonalView".equals(method)){
            personalView(request,response);
            return;
        }else if("EditPasswod".equals(method)){
            editPassword(request,response);
            return;
        }
        try {
            request.getRequestDispatcher("system.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void editPassword(HttpServletRequest request,
                              HttpServletResponse response) {
        // TODO Auto-generated method stub
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newpassword");
        response.setCharacterEncoding("UTF-8");
        int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
        if(userType == 1){
            //管理员
            Admin admin = (Admin)request.getSession().getAttribute("user");
            if(!admin.getPassword().equals(password)){
                try {
                    response.getWriter().write("原密码错误！");
                    return;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            AdminDao adminDao = new AdminDao();
            if(adminDao.editPassword(admin, newPassword)){
                try {
                    response.getWriter().write("success");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally{
                    adminDao.closeCon();
                }
            }else{
                try {
                    response.getWriter().write("数据库修改错误");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    adminDao.closeCon();
                }
            }
        }
        if(userType == 2){
            //学生
            Student student = (Student)request.getSession().getAttribute("user");
            if(!student.getPassword().equals(password)){
                try {
                    response.getWriter().write("原密码错误！");
                    return;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            StudentDao studentDao = new StudentDao();
            if(studentDao.editPassword(student, newPassword)){
                try {
                    response.getWriter().write("success");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally{
                    studentDao.closeCon();
                }
            }else{
                try {
                    response.getWriter().write("数据库修改错误");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    studentDao.closeCon();
                }
            }
        }
        if(userType == 3){
            //教师
            Teacher teacher = (Teacher)request.getSession().getAttribute("user");
            if(!teacher.getPassword().equals(password)){
                try {
                    response.getWriter().write("原密码错误！");
                    return;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            TeacherDao teacherDao = new TeacherDao();
            if(teacherDao.editPassword(teacher, newPassword)){
                try {
                    response.getWriter().write("success");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally{
                    teacherDao.closeCon();
                }
            }else{
                try {
                    response.getWriter().write("数据库修改错误");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    teacherDao.closeCon();
                }
            }
        }
    }
    private void personalView(HttpServletRequest request,
                              HttpServletResponse response) {
        // TODO Auto-generated method stub
        try {
            request.getRequestDispatcher("personalView.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
