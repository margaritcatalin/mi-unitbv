package com.catalin.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the comentariu database table.
 * 
 */
@Entity
@NamedQuery(name = "Comentariu.findAll", query = "SELECT c FROM Comentariu c")
public class Comentariu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComentariu;

	private int accept;

	private String comentariu;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;

	// bi-directional many-to-one association to Postare
	@ManyToOne
	@JoinColumn(name = "idPostare")
	private Postare postare;

	public Comentariu() {
	}

	public int getIdComentariu() {
		return this.idComentariu;
	}

	public void setIdComentariu(int idComentariu) {
		this.idComentariu = idComentariu;
	}

	public int getAccept() {
		return this.accept;
	}

	public void setAccept(int accept) {
		this.accept = accept;
	}

	public String getComentariu() {
		return this.comentariu;
	}

	public void setComentariu(String comentariu) {
		this.comentariu = comentariu;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Postare getPostare() {
		return this.postare;
	}

	public void setPostare(Postare postare) {
		this.postare = postare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accept;
		result = prime * result + ((comentariu == null) ? 0 : comentariu.hashCode());
		result = prime * result + idComentariu;
		result = prime * result + ((postare == null) ? 0 : postare.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Comentariu other = (Comentariu) obj;
		if (accept != other.accept)
			return false;
		if (comentariu == null) {
			if (other.comentariu != null)
				return false;
		} else if (!comentariu.equals(other.comentariu))
			return false;
		if (idComentariu != other.idComentariu)
			return false;
		if (postare == null) {
			if (other.postare != null)
				return false;
		} else if (!postare.equals(other.postare))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentariu [idComentariu=" + idComentariu + ", accept=" + accept + ", comentariu=" + comentariu
				+ ", user=" + user + "]";
	}

}