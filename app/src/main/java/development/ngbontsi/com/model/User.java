package development.ngbontsi.com.model;



import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable{

	@SerializedName("id")
	private int id;
	@SerializedName("first_name")
	private String name;

	@SerializedName("last_name")
	private String lastName;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	@SerializedName("address_id")
	private int addressid;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@SerializedName("email")
	private String email;
	@SerializedName("password")
	private String password;
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
