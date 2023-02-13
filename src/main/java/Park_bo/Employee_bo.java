package Park_bo;

public class Employee_bo {
private int id;
private String name;
private String job;
private String doj;
private String phone;
private String email;
private String dob;
private String adhaar;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getAdhaar() {
	return adhaar;
}
public void setAdhaar(String adhaar) {
	this.adhaar = adhaar;
}
public Employee_bo(String name, String job, String doj, String phone, String email, String dob, String adhaar) {
	super();
	this.name = name;
	this.job = job;
	this.doj = doj;
	this.phone = phone;
	this.email = email;
	this.dob = dob;
	this.adhaar = adhaar;
}


public String toString() {
	return "Employee_bo [id=" + id + ", name=" + name + ", job=" + job + ", doj=" + doj + ", phone=" + phone
			+ ", email=" + email + ", dob=" + dob + ", adhaar=" + adhaar + "]";
}
public Employee_bo() {
	super();
	// TODO Auto-generated constructor stub
}



}