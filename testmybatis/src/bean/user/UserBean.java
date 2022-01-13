package bean.user;

import java.util.Arrays;
import java.util.Date;

import bean.pub.Address;

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
	protected Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "{address:"+address+"id:" + id + ", account:" + account + ", pwd:" + pwd + ", age:" + age + ", gender:" + gender
				+ ", province:" + province + ", hobbies:" + Arrays.toString(hobbies) + ", birthday:" + birthday
				+ ", modiDate:" + modiDate + "}";
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Date getModiDate() {
		return modiDate;
	}
	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
	public Long getId() {
		return id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public int getAge() {
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
}
