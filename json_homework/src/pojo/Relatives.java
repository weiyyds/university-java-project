package pojo;
//紧急联系人
public class Relatives {
	private String name;
	private String phoneNumber;//手机号码
	
	public Relatives() {
		super();
	}

	public Relatives(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "relatives [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
