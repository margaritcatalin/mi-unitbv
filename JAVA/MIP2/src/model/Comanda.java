package model;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detaliicomandas == null) ? 0 : detaliicomandas.hashCode());
		result = prime * result + idComanda;
		result = prime * result + pretTotal;
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
		Comanda other = (Comanda) obj;
		if (detaliicomandas == null) {
			if (other.detaliicomandas != null)
				return false;
		} else if (!detaliicomandas.equals(other.detaliicomandas))
			return false;
		if (idComanda != other.idComanda)
			return false;
		if (pretTotal != other.pretTotal)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}