package catalin.angajat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Angajat implements Serializable {
	static final long serialVersionUID = 5653493248680665297L;
	public String nume, adresa;
	public int salariu;
	private String parola;

	public Angajat(String nume, int salariu, String parola) {
		this.nume = nume;
		this.salariu = salariu;
		this.parola = parola;
		this.adresa = "Iasi";
	}

	public String toString() {
		return nume + " (" + salariu + ")";
	}

	public String criptare(String input, int offset) {
		StringBuffer sb = new StringBuffer();
		for (int n = 0; n < input.length(); n++) {
			sb.append((char) (offset + input.charAt(n)));
		}
		return sb.toString();
	}
	private void writeObject(ObjectOutputStream stream) throws IOException{
		parola=criptare(parola,3);
		stream.defaultWriteObject();
		parola=criptare(parola,-3);
	}
	private void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException{
		stream.defaultReadObject();
		parola=criptare(parola,-3);
	}
}
