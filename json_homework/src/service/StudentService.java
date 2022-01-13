package service;

import java.util.ArrayList;

import com.google.gson.Gson;

import pojo.Relatives;
import pojo.Student;


public class StudentService{
	public static void main(String[] args) {
		Gson gson=new Gson();
		Relatives relativesnew=new Relatives("史卓越","19120592556");
		Student student=new Student("史小明",22,"男","20195533432","广东农工商职业技术学院",relativesnew);		
		
		//创建一个学生数组
		ArrayList<Student> arr=new ArrayList<Student>();
		arr.add(student);
		String str=gson.toJson(arr);
		System.out.println(str);
		
	}

}
