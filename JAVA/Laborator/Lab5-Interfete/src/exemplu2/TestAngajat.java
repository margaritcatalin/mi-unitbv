package exemplu2;

import java.util.*;


public class TestAngajat {
	public static void main(String[] args) {
	ArrayList<Angajat> ang = new ArrayList<Angajat>();
	Angajat a = new Programator("Anghel Mihai","1970715398076", 20);
	Angajat a1 = new Programator("Balas Florin","5010715398076", 15);
	Angajat a3 = new Sudor("Ene George","1840715398076","G1");
	Angajat a4 = new Sudor("Margarit Marian","1790715398076","G3");
	ang.add(a);
	ang.add(a1);
	ang.add(a3);
	ang.add(a4);
	Collections.sort(ang, new Comparator<Angajat>() {
	@Override
	public int compare(Angajat a1, Angajat a2) {
		if (a1.getAni() > a2.getAni())
			return 1;
		else if (a1.getAni() < a2.getAni())
			return -1;
		else
			return 0;
	}
});
	for (Angajat an : ang)
		if(an instanceof Programator)
			((Programator)an).afiseazaAngajat();
		else if(an instanceof Sudor)
			((Sudor)an).afiseazaAngajat();
	}
			
}
