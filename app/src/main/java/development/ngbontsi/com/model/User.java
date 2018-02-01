package development.ngbontsi.com.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "users")
public class User implements Serializable{

	@PrimaryKey(autoGenerate = true)
	private int id;
	@ColumnInfo(name= "first_name")
	private String name;

	@ColumnInfo(name="last_name")
	private String lastName;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	@ColumnInfo(name = "address_id")
	private int addressid;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ColumnInfo(name="email")
	private String email;
	@ColumnInfo(name= "password")
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
