package Park_bo;

public class Visitor_data {
private int id;
private String name;
private String email;
private String username;
private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public Visitor_data(String name, String email, String username, String password) {
	super();
	this.name = name;
	this.email = email;
	this.username = username;
	this.password = password;
}
public Visitor_data() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Visitor_data [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
			+ password + "]";
}





}
