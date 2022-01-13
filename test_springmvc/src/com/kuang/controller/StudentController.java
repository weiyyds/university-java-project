package com.kuang.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuang.entity.Student;
import com.kuang.utils.UserValidator;


@RestController
public class StudentController{
	/*
	@PostMapping("/student")
	public Student accept_Form(Student student){
		//将表单数据注入到Student对象中,用对象接收，会自动注入	
		return  student;
		
	}*/
	@PostMapping(value="/student",produces="application/json;charset=utf-8")
	public Map accept_Form(Student student,Errors errors,HttpServletRequest request,HttpServletResponse response){
		UserValidator validator=new UserValidator();
		validator.validate(student, errors);
		HashMap map=new HashMap<String, String>();
		if(errors.hasErrors()) {	
			map.put("msg", errors.getAllErrors());
			return (Map) map;
		}else {
			map.put("msg", "信息已收到");
			return (Map) map;
		}
		/*if(student!=null) {
			return  "信息已收取到";
		}else {
			return "信息收取失败";
		}*/
		
	}

	
}
