package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalii_comanda database table.
 * 
 */
@Entity
@Table(name="detalii_comanda")
@NamedQuery(name="DetaliiComanda.findAll", query="SELECT d FROM DetaliiComanda d")
public class DetaliiComanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detaliu_id")
	private String detaliuId;

	private int cantitate;

	@Column(name="cod_produs")
	private int codProdus;

	@Column(name="comanda_id")
	private int comandaId;

	private int prettotal;

	public DetaliiComanda() {
	}

	public String getDetaliuId() {
		return this.detaliuId;
	}

	public void setDetaliuId(String detaliuId) {
		this.detaliuId = detaliuId;
	}

	public int getCantitate() {
		return this.cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public int getCodProdus() {
		return this.codProdus;
	}

	public void setCodProdus(int codProdus) {
		this.codProdus = codProdus;
	}

	public int getComandaId() {
		return this.comandaId;
	}

	public void setComandaId(int comandaId) {
		this.comandaId = comandaId;
	}

	public int getPrettotal() {
		return this.prettotal;
	}

	public void setPrettotal(int prettotal) {
		this.prettotal = prettotal;
	}

}