package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produs database table.
 * 
 */
@Entity
@NamedQuery(name="Produs.findAll", query="SELECT p FROM Produs p")
public class Produs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_produs")
	private String codProdus;

	private String denumire;

	@Column(name="id_vanzator")
	private int idVanzator;

	private int pret;

	private int stoc;

	public Produs() {
	}

	public String getCodProdus() {
		return this.codProdus;
	}

	public void setCodProdus(String codProdus) {
		this.codProdus = codProdus;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getIdVanzator() {
		return this.idVanzator;
	}

	public void setIdVanzator(int idVanzator) {
		this.idVanzator = idVanzator;
	}

	public int getPret() {
		return this.pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public int getStoc() {
		return this.stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

}