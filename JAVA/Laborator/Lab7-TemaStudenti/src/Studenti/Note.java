package Studenti;
import java.util.Date;

public class Note {
private String materie;
private Double nota;
private  String data;

public Note(String materie, Double nota, String data) {
	super();
	this.materie = materie;
	this.nota = nota;
	this.data = data;
}

public Note() {
	super();
	
	// TODO Auto-generated constructor stub
}

public String getMaterie() {
	return materie;
}

public void setMaterie(String materie) {
	this.materie = materie;
}

public Double getNota() {
	return nota;
}

public void setNota(Double readNota) {
	this.nota = readNota;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

@Override
public String toString() {
	return "Note [materie=" + materie + ", nota=" + nota + ", data=" + data + "]";
}


}
