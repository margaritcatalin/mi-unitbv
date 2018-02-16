package com.catalin.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comanda database table.
 * 
 */
@Entity
@NamedQuery(name="Comanda.findAll", query="SELECT c FROM Comanda c")
public class Comanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idComanda;

	private int pretTotal;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Detaliicomanda
	@OneToMany(mappedBy="comanda")
	private List<Detaliicomanda> detaliicomandas;

	public Comanda() {
	}

	public int getIdComanda() {
		return this.idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public int getPretTotal() {
		return this.pretTotal;
	}

	public void setPretTotal(int pretTotal) {
		this.pretTotal = pretTotal;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Detaliicomanda> getDetaliicomandas() {
		return this.detaliicomandas;
	}

	public void setDetaliicomandas(List<Detaliicomanda> detaliicomandas) {
		this.detaliicomandas = detaliicomandas;
	}

	public Detaliicomanda addDetaliicomanda(Detaliicomanda detaliicomanda) {
		getDetaliicomandas().add(detaliicomanda);
		detaliicomanda.setComanda(this);

		return detaliicomanda;
	}

	public Detaliicomanda removeDetaliicomanda(Detaliicomanda detaliicomanda) {
		getDetaliicomandas().remove(detaliicomanda);
		detaliicomanda.setComanda(null);

		return detaliicomanda;
	}

}