package exemplu2;

public class Sudor extends Angajat implements IAngajat{
private String grupa;
public Sudor(String nume,String cnp,String grupa) {
	super(nume,cnp);
	this.setGrupa(grupa);
}
public String getGrupa() {
	return grupa;
}
public void setGrupa(String grupa) {
	this.grupa = grupa;
}
@Override
public int calculeazaSalariu() {
	// TODO Auto-generated method stub
	if(grupa=="G1")
		if(afiseazaGen()=='F')
			return 5*NR_ZILE*NORMA_ZI;
		else if(grupa=="G2")
			return 7*NR_ZILE*NORMA_ZI;
		return 9*NR_ZILE*NORMA_ZI;
}
@Override
public void afiseazaAngajat() {
	// TODO Auto-generated method stub
	System.out.println("Nume: "+getNume()+" Salariu:"+calculeazaSalariu()+" Ani pana la pensie:"+aniPanaLaPensie());
}
@Override
public char afiseazaGen() {
	int cnpg = Integer.parseInt(cnp.substring(0,1));
	if(cnpg==5||cnpg==1)
		return 'M';
	return 'F';
}

@Override
public int aniPanaLaPensie() {
	// TODO Auto-generated method stub
	if(grupa=="G1")
		if(afiseazaGen()=='F')
			return 65-getVarsta();
		else return 67-getVarsta();
		else if(grupa=="G2")
			if(afiseazaGen()=='F')
				return 60-getVarsta();
			else return 62-getVarsta();
		else
			if(afiseazaGen()=='F')
				return 50-getVarsta();
			 return 55-getVarsta();
}
public int getAni() {
	return aniPanaLaPensie();
}

}
