package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUser;

	private int administrator;

	private String password;

	private String username;

	//bi-directional many-to-one association to Masinidetinute
	@OneToMany(mappedBy="user")
	private List<Masinidetinute> masinidetinutes;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(int administrator) {
		this.administrator = administrator;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Masinidetinute> getMasinidetinutes() {
		return this.masinidetinutes;
	}

	public void setMasinidetinutes(List<Masinidetinute> masinidetinutes) {
		this.masinidetinutes = masinidetinutes;
	}

	public Masinidetinute addMasinidetinute(Masinidetinute masinidetinute) {
		getMasinidetinutes().add(masinidetinute);
		masinidetinute.setUser(this);

		return masinidetinute;
	}

	public Masinidetinute removeMasinidetinute(Masinidetinute masinidetinute) {
		getMasinidetinutes().remove(masinidetinute);
		masinidetinute.setUser(null);

		return masinidetinute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + administrator;
		result = prime * result + idUser;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (administrator != other.administrator)
			return false;
		if (idUser != other.idUser)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + "]";
	}

}