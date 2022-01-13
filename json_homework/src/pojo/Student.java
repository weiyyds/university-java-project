package pojo;
//学生实体类
public class Student{
	private String name;
	private int age;
	private String gender;//性别
	private String sno;//学号
	private String school;//学校
	private Relatives relatives;//紧急联系人
	public Student() {
		super();
	}
	public Student(String name, int age, String gender, String sno, String school, Relatives relatives) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.sno = sno;
		this.school = school;
		this.relatives = relatives;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Relatives getRelatives() {
		return relatives;
	}
	public void setRelatives(Relatives relatives) {
		this.relatives = relatives;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + ", sno=" + sno + ", school=" + school
				+ ", relatives=" + relatives + "]";
	}
	
}
