package exemplu2;

public class Programator extends Angajat implements IAngajat{
private int salariuOra;
public Programator(String nume,String cnp,int sal) {
	super(nume,cnp);
	this.salariuOra=sal;
}
	@Override
	public int calculeazaSalariu() {
		// TODO Auto-generated method stub
		return salariuOra*NR_ZILE*NORMA_ZI;
	}

	@Override
	public void afiseazaAngajat() {
		// TODO Auto-generated method stub
		System.out.println(" Nume:"+getNume()+" Salariu:"+calculeazaSalariu()+" Ani pana la pensie:"+aniPanaLaPensie());
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
		if(afiseazaGen()=='F')
			return 65-getVarsta();
		return 67-getVarsta();
	}
	public int getSalariuOra() {
		return salariuOra;
	}
	public void setSalariu(int salariu) {
		this.salariuOra = salariu;
	}
	public int getAni() {
		return aniPanaLaPensie();
	}
}
