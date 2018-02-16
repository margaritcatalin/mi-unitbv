package exemplu2;

import java.time.LocalDateTime;

public abstract class Angajat {
protected String nume;
protected String cnp;
public Angajat() {
	
}
public Angajat(String nume,String cnp) {
	this.nume=nume;
	this.cnp=cnp;
}
public String getNume() {
	return nume;
}
public String getCnp() {
	return cnp;
}
public int getVarsta() {
	int azi=LocalDateTime.now().getYear();
	int anulN = Integer.parseInt(cnp.substring(1,3));
	int cnpg = Integer.parseInt(cnp.substring(0,1));
	if(cnpg==2||cnpg==1)
		anulN=1900+anulN;
	if(cnpg==5||cnpg==6)
		anulN=2000+anulN;
	return azi-anulN;
}
abstract int getAni();
}
