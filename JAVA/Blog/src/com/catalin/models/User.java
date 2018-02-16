package com.catalin.models;

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

	private String password;

	private int tip;

	private String username;

	//bi-directional many-to-one association to Comentariu
	@OneToMany(mappedBy="user")
	private List<Comentariu> comentarius;

	//bi-directional many-to-one association to Postare
	@OneToMany(mappedBy="user")
	private List<Postare> postares;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTip() {
		return this.tip;
	}

	public void setTip(int tip) {
		this.tip = tip;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Comentariu> getComentarius() {
		return this.comentarius;
	}

	public void setComentarius(List<Comentariu> comentarius) {
		this.comentarius = comentarius;
	}

	public Comentariu addComentarius(Comentariu comentarius) {
		getComentarius().add(comentarius);
		comentarius.setUser(this);

		return comentarius;
	}

	public Comentariu removeComentarius(Comentariu comentarius) {
		getComentarius().remove(comentarius);
		comentarius.setUser(null);

		return comentarius;
	}

	public List<Postare> getPostares() {
		return this.postares;
	}

	public void setPostares(List<Postare> postares) {
		this.postares = postares;
	}

	public Postare addPostare(Postare postare) {
		getPostares().add(postare);
		postare.setUser(this);

		return postare;
	}

	public Postare removePostare(Postare postare) {
		getPostares().remove(postare);
		postare.setUser(null);

		return postare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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