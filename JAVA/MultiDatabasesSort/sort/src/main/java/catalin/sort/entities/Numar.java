package catalin.sort.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Numar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int numberid;
    private int numar;
	public int getNumberid() {
		return numberid;
	}
	public void setNumberid(int numberid) {
		this.numberid = numberid;
	}
	public int getNumar() {
		return numar;
	}
	public void setNumar(int numar) {
		this.numar = numar;
	}

}
