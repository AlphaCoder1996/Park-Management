package Park_bo;

public class Adminstrators {

	private String Id;
	private String pass;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Adminstrators [Id=" + Id + ", pass=" + pass + "]";
	}
	
	

}
