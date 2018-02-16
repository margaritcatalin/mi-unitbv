package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id_User;

	private int buget;

	private String password;

	private int status;

	private String username;

	private int vanzator;

	public User() {
	}

	public String getId_User() {
		return this.id_User;
	}

	public void setId_User(String id_User) {
		this.id_User = id_User;
	}

	public int getBuget() {
		return this.buget;
	}

	public void setBuget(int buget) {
		this.buget = buget;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getVanzator() {
		return this.vanzator;
	}

	public void setVanzator(int vanzator) {
		this.vanzator = vanzator;
	}

}