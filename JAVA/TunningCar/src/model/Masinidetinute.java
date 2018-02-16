package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the masinidetinute database table.
 * 
 */
@Entity
@NamedQuery(name="Masinidetinute.findAll", query="SELECT m FROM Masinidetinute m")
public class Masinidetinute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMDetinuta;

	//bi-directional many-to-one association to Masini
	@ManyToOne
	@JoinColumn(name="idMasina")
	private Masini masini;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Masinidetinute() {
	}

	public int getIdMDetinuta() {
		return this.idMDetinuta;
	}

	public void setIdMDetinuta(int idMDetinuta) {
		this.idMDetinuta = idMDetinuta;
	}

	public Masini getMasini() {
		return this.masini;
	}

	public void setMasini(Masini masini) {
		this.masini = masini;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}