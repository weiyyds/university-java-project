package com.kuang.entity;

import java.util.Arrays;
import java.util.Date;

public class UserBean {
	protected Long id;
	protected String account;
	protected String pwd;
	protected Integer age;
	protected String gender;
	protected String province;
	protected String[] hobbies;
	protected Date birthday;
	protected Date modiDate;
	public UserBean() {
		super();
	}
	public UserBean(Long id, String account, String pwd, Integer age, String gender, String province, String[] hobbies,
			Date birthday, Date modiDate) {
		super();
		this.id = id;
		this.account = account;
		this.pwd = pwd;
		this.age = age;
		this.gender = gender;
		this.province = province;
		this.hobbies = hobbies;
		this.birthday = birthday;
		this.modiDate = modiDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getModiDate() {
		return modiDate;
	}
	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", account=" + account + ", pwd=" + pwd + ", age=" + age + ", gender=" + gender
				+ ", province=" + province + ", hobbies=" + Arrays.toString(hobbies) + ", birthday=" + birthday
				+ ", modiDate=" + modiDate + "]";
	}
	
}
