package Studenti;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Student {
	private String nume;
	private String prenume;
	private String cnp;
	private String nrTelefon;
	private ArrayList<Note> note;

	public Student(String nume, String prenume, String cnp, String nrTelefon, ArrayList<Note> a) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		this.nrTelefon = nrTelefon;
		this.note = a;
	}

	public Student() {
		super();
		this.note = new ArrayList();
		// TODO Auto-generated constructor stub
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNrTelefon() {
		return nrTelefon;
	}

	public void setNrTelefon(String nrTelefon) {
		this.nrTelefon = nrTelefon;
	}

	public ArrayList<Note> getNote() {
		return note;
	}

	public void setNote(ArrayList<Note> note) {
		this.note = note;
	}

	public void addNota(Note nota) {
		this.note.add(nota);
	}

	public int getAnulNasterii() {
		int azi = LocalDateTime.now().getYear();
		int anulN = Integer.parseInt(cnp.substring(1, 3));
		int cnpg = Integer.parseInt(cnp.substring(0, 1));
		if (cnpg == 2 || cnpg == 1)
			anulN = 1900 + anulN;
		if (cnpg == 5 || cnpg == 6)
			anulN = 2000 + anulN;
		return anulN;
	}

	public int getPrefix() {
		return Integer.parseInt(nrTelefon.substring(1, 3));
	}

	public int getLunaZiNastere() {
		return Integer.parseInt(cnp.substring(3, 7));
	}

	public Double getNotaLaMateria(String materia) {
		for (Note nota : note) {
			if (nota.getMaterie().compareTo(materia) == 0)
				return nota.getNota();
		}
		return (double) -1;
	}

	public Boolean studentCuRestante() {
		for (Note nota : note) {
			if (nota.getNota() < 5)
				return true;
		}
		return false;
	}

public void afisareRestante() {
for (Note nota : note) {
	if (nota.getNota() < 5) 
	System.out.println(nota.getMaterie()+" nota:"+nota.getNota());
}
}
	@Override
	public String toString() {
		return "Student [nume=" + nume + ", prenume=" + prenume + ", cnp=" + cnp + ", nrTelefon=" + nrTelefon
				+ ", note=" + note + "]";
	}

}
