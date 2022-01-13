package bean.pub;

public class Address {
	String province;
	String city;
	String district;
	String street;
	String info;
	
	
	@Override
	public String toString() {
		return "{province:" + province + ", city:" + city + ", district:" + district + ", street:" + street + ", info:"
				+ info + "}";
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
