package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private int idProdus;

	private String denumire;

	private int pret;

	private int stoc;

	//bi-directional many-to-one association to Detaliicomanda
	@OneToMany(mappedBy="produs")
	private List<Detaliicomanda> detaliicomandas;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idVanzator")
	private User user;

	public Produs() {
	}

	public int getIdProdus() {
		return this.idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
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

	public List<Detaliicomanda> getDetaliicomandas() {
		return this.detaliicomandas;
	}

	public void setDetaliicomandas(List<Detaliicomanda> detaliicomandas) {
		this.detaliicomandas = detaliicomandas;
	}

	public Detaliicomanda addDetaliicomanda(Detaliicomanda detaliicomanda) {
		getDetaliicomandas().add(detaliicomanda);
		detaliicomanda.setProdus(this);

		return detaliicomanda;
	}

	public Detaliicomanda removeDetaliicomanda(Detaliicomanda detaliicomanda) {
		getDetaliicomandas().remove(detaliicomanda);
		detaliicomanda.setProdus(null);

		return detaliicomanda;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}