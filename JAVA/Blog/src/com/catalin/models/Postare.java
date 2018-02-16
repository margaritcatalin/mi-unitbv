package com.catalin.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the postare database table.
 * 
 */
@Entity
@NamedQuery(name="Postare.findAll", query="SELECT p FROM Postare p")
public class Postare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPostare;

	private String postare;

	private String titlu;

	//bi-directional many-to-one association to Comentariu
	@OneToMany(mappedBy="postare")
	private List<Comentariu> comentarius;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Postare() {
	}

	public int getIdPostare() {
		return this.idPostare;
	}

	public void setIdPostare(int idPostare) {
		this.idPostare = idPostare;
	}

	public String getPostare() {
		return this.postare;
	}

	public void setPostare(String postare) {
		this.postare = postare;
	}

	public String getTitlu() {
		return this.titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public List<Comentariu> getComentarius() {
		return this.comentarius;
	}

	public void setComentarius(List<Comentariu> comentarius) {
		this.comentarius = comentarius;
	}

	public Comentariu addComentarius(Comentariu comentarius) {
		getComentarius().add(comentarius);
		comentarius.setPostare(this);

		return comentarius;
	}

	public Comentariu removeComentarius(Comentariu comentarius) {
		getComentarius().remove(comentarius);
		comentarius.setPostare(null);

		return comentarius;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPostare;
		result = prime * result + ((postare == null) ? 0 : postare.hashCode());
		result = prime * result + ((titlu == null) ? 0 : titlu.hashCode());
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
		Postare other = (Postare) obj;
		if (idPostare != other.idPostare)
			return false;
		if (postare == null) {
			if (other.postare != null)
				return false;
		} else if (!postare.equals(other.postare))
			return false;
		if (titlu == null) {
			if (other.titlu != null)
				return false;
		} else if (!titlu.equals(other.titlu))
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
		return "Postare [idPostare=" + idPostare + ", postare=" + postare + ", titlu=" + titlu + ", user=" + user + "]";
	}

}