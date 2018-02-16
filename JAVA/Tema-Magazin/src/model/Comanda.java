package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comanda database table.
 * 
 */
@Entity
@NamedQuery(name="Comanda.findAll", query="SELECT c FROM Comanda c")
public class Comanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comanda_id")
	private String comandaId;

	private int id_User;

	public Comanda() {
	}

	public String getComandaId() {
		return this.comandaId;
	}

	public void setComandaId(String comandaId) {
		this.comandaId = comandaId;
	}

	public int getId_User() {
		return this.id_User;
	}

	public void setId_User(int id_User) {
		this.id_User = id_User;
	}

}