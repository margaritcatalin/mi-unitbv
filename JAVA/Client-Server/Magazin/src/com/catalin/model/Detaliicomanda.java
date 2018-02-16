package com.catalin.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detaliicomanda database table.
 * 
 */
@Entity
@NamedQuery(name="Detaliicomanda.findAll", query="SELECT d FROM Detaliicomanda d")
public class Detaliicomanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDetaliiComanda;

	//bi-directional many-to-one association to Comanda
	@ManyToOne
	@JoinColumn(name="idComanda")
	private Comanda comanda;

	//bi-directional many-to-one association to Produs
	@ManyToOne
	@JoinColumn(name="idProdus")
	private Produs produs;

	public Detaliicomanda() {
	}

	public int getIdDetaliiComanda() {
		return this.idDetaliiComanda;
	}

	public void setIdDetaliiComanda(int idDetaliiComanda) {
		this.idDetaliiComanda = idDetaliiComanda;
	}

	public Comanda getComanda() {
		return this.comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Produs getProdus() {
		return this.produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}

}