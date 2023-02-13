package Park_bo;

public class VisitorVarify {
	private String username;
	private String password;
	public VisitorVarify(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public VisitorVarify() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "VisitorVarify [username=" + username + ", password=" + password + "]";
	}
	
	            

}
