package development.ngbontsi.com.model;



import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Login implements Serializable{

	@SerializedName("id")
	private int id;
	@SerializedName("username")
	private String username;
	@SerializedName("password")
	private String password;
	@SerializedName("user_role")
	private String userrole;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
}
