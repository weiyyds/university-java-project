package com.kuang.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kuang.entity.Student;

/**检查用户数据是否符合规范*/
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clz) {
		// TODO Auto-generated method stub
		return Student.class.equals(clz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Student student=(Student)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.student.username");
		int age=student.getAge();
		if(age<0||age>100) {
			errors.reject("error.user.age", "年龄不能小于0或者大于100");
		}
		
	}
	
}
