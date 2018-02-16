package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private int idUser;

	private int buget;

	private String password;

	private int tip;

	private String username;

	//bi-directional many-to-one association to Comanda
	@OneToMany(mappedBy="user")
	private List<Comanda> comandas;

	//bi-directional many-to-one association to Produs
	@OneToMany(mappedBy="user")
	private List<Produs> produses;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public List<Comanda> getComandas() {
		return this.comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	public Comanda addComanda(Comanda comanda) {
		getComandas().add(comanda);
		comanda.setUser(this);

		return comanda;
	}

	public Comanda removeComanda(Comanda comanda) {
		getComandas().remove(comanda);
		comanda.setUser(null);

		return comanda;
	}

	public List<Produs> getProduses() {
		return this.produses;
	}

	public void setProduses(List<Produs> produses) {
		this.produses = produses;
	}

	public Produs addProdus(Produs produs) {
		getProduses().add(produs);
		produs.setUser(this);

		return produs;
	}

	public Produs removeProdus(Produs produs) {
		getProduses().remove(produs);
		produs.setUser(null);

		return produs;
	}

}