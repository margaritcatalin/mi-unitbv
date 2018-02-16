package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the masini database table.
 * 
 */
@Entity
@NamedQuery(name="Masini.findAll", query="SELECT m FROM Masini m")
public class Masini implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMasina;

	private int aer_conditionat;

	private int capacitate_cilindrica;

	private String combustibil;

	private String culoare;

	private String cutie_de_viteze;

	private String marca;

	private String model;

	private String norma_de_poluare;

	private String transmisie;

	//bi-directional many-to-one association to Masinidetinute
	@OneToMany(mappedBy="masini")
	private List<Masinidetinute> masinidetinutes;

	public Masini() {
	}

	public int getIdMasina() {
		return this.idMasina;
	}

	public void setIdMasina(int idMasina) {
		this.idMasina = idMasina;
	}

	public int getAer_conditionat() {
		return this.aer_conditionat;
	}

	public void setAer_conditionat(int aer_conditionat) {
		this.aer_conditionat = aer_conditionat;
	}

	public int getCapacitate_cilindrica() {
		return this.capacitate_cilindrica;
	}

	public void setCapacitate_cilindrica(int capacitate_cilindrica) {
		this.capacitate_cilindrica = capacitate_cilindrica;
	}

	public String getCombustibil() {
		return this.combustibil;
	}

	public void setCombustibil(String combustibil) {
		this.combustibil = combustibil;
	}

	public String getCuloare() {
		return this.culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public String getCutie_de_viteze() {
		return this.cutie_de_viteze;
	}

	public void setCutie_de_viteze(String cutie_de_viteze) {
		this.cutie_de_viteze = cutie_de_viteze;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNorma_de_poluare() {
		return this.norma_de_poluare;
	}

	public void setNorma_de_poluare(String norma_de_poluare) {
		this.norma_de_poluare = norma_de_poluare;
	}

	public String getTransmisie() {
		return this.transmisie;
	}

	public void setTransmisie(String transmisie) {
		this.transmisie = transmisie;
	}

	public List<Masinidetinute> getMasinidetinutes() {
		return this.masinidetinutes;
	}

	public void setMasinidetinutes(List<Masinidetinute> masinidetinutes) {
		this.masinidetinutes = masinidetinutes;
	}

	public Masinidetinute addMasinidetinute(Masinidetinute masinidetinute) {
		getMasinidetinutes().add(masinidetinute);
		masinidetinute.setMasini(this);

		return masinidetinute;
	}

	public Masinidetinute removeMasinidetinute(Masinidetinute masinidetinute) {
		getMasinidetinutes().remove(masinidetinute);
		masinidetinute.setMasini(null);

		return masinidetinute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aer_conditionat;
		result = prime * result + capacitate_cilindrica;
		result = prime * result + ((combustibil == null) ? 0 : combustibil.hashCode());
		result = prime * result + ((culoare == null) ? 0 : culoare.hashCode());
		result = prime * result + ((cutie_de_viteze == null) ? 0 : cutie_de_viteze.hashCode());
		result = prime * result + idMasina;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((masinidetinutes == null) ? 0 : masinidetinutes.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((norma_de_poluare == null) ? 0 : norma_de_poluare.hashCode());
		result = prime * result + ((transmisie == null) ? 0 : transmisie.hashCode());
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
		Masini other = (Masini) obj;
		if (aer_conditionat != other.aer_conditionat)
			return false;
		if (capacitate_cilindrica != other.capacitate_cilindrica)
			return false;
		if (combustibil == null) {
			if (other.combustibil != null)
				return false;
		} else if (!combustibil.equals(other.combustibil))
			return false;
		if (culoare == null) {
			if (other.culoare != null)
				return false;
		} else if (!culoare.equals(other.culoare))
			return false;
		if (cutie_de_viteze == null) {
			if (other.cutie_de_viteze != null)
				return false;
		} else if (!cutie_de_viteze.equals(other.cutie_de_viteze))
			return false;
		if (idMasina != other.idMasina)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (masinidetinutes == null) {
			if (other.masinidetinutes != null)
				return false;
		} else if (!masinidetinutes.equals(other.masinidetinutes))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (norma_de_poluare == null) {
			if (other.norma_de_poluare != null)
				return false;
		} else if (!norma_de_poluare.equals(other.norma_de_poluare))
			return false;
		if (transmisie == null) {
			if (other.transmisie != null)
				return false;
		} else if (!transmisie.equals(other.transmisie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[idMasina=" + idMasina + ", aer_conditionat=" + aer_conditionat + ", capacitate_cilindrica="
				+ capacitate_cilindrica + ", combustibil=" + combustibil + ", culoare=" + culoare + ", cutie_de_viteze="
				+ cutie_de_viteze + ", marca=" + marca + ", model=" + model + ", norma_de_poluare=" + norma_de_poluare
				+ ", transmisie=" + transmisie + "]";
	}

}