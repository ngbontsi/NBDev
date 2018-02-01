package development.ngbontsi.com.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "login")
public class Login implements Serializable{

	@PrimaryKey(autoGenerate = true)
	private int id;
	@ColumnInfo(name= "username")
	private String username;
	@ColumnInfo(name= "password")
	private String password;
	@ColumnInfo(name = "user_role")
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
