import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.sun.jndi.ldap.ext.StartTlsResponseImpl;

public class Automat implements Serializable {
	private String stareInitiala;
	private ArrayList<String> stari = new ArrayList<String>();
	private ArrayList<String> stariFinale = new ArrayList<String>();
	private ArrayList<String> alfabet = new ArrayList<String>();
	private ArrayList<Arc> arce = new ArrayList<Arc>();

	public Automat(String stareInitiala, ArrayList<String> nrstari, ArrayList<String> stariFinale,
			ArrayList<String> alfabet, ArrayList<Arc> arce) {
		super();
		this.stareInitiala = stareInitiala;
		this.stari = nrstari;
		this.stariFinale = stariFinale;
		this.alfabet = alfabet;
		this.arce = arce;
	}

	public Automat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStareInitiala() {
		return stareInitiala;
	}

	public void setStareInitiala(String stareInitiala) {
		this.stareInitiala = stareInitiala;
	}

	public ArrayList<String> getStariFinale() {
		return stariFinale;
	}

	public ArrayList<String> getStari() {
		return stari;
	}

	public void setStariFinale(ArrayList<String> stariFinale) {
		this.stariFinale = stariFinale;
	}

	public ArrayList<String> getAlfabet() {
		return alfabet;
	}

	public void setAlfabet(ArrayList<String> alfabet) {
		this.alfabet = alfabet;
	}

	public ArrayList<Arc> getArce() {
		return arce;
	}

	public void setArce(ArrayList<Arc> arce) {
		this.arce = arce;
	}

	public void addStare(String stare) {
		this.stari.add(stare);
	}

	public void addArc(Arc arc) {
		this.arce.add(arc);
	}

	public void addLiteraAlfabet(String l) {
		this.alfabet.add(l);
	}

	public void addStareFinala(String stare) {
		this.stariFinale.add(stare);
	}

	@Override
	public String toString() {
		return "Automat [stareInitiala=" + stareInitiala + "Stari=" + stari + ", stariFinale=" + stariFinale
				+ ", alfabet=" + alfabet + ", arce=" + arce + "]";
	}

	public void verificare(String cuvant) {
		String stareActuala = null;
		stareActuala = getStareInitiala();
		for (int i = 0; i < cuvant.length(); i++) {

			if (getAlfabet().contains(Character.toString(cuvant.charAt(i)))) {
				stareActuala = Verificare(getArce(), cuvant.charAt(i), stareActuala);
			} else
				System.out.println("Acest cuvant are litere ce nu sunt in alfabetul automatului.");
			System.out.println(stareActuala);
		}
		if (getStariFinale().contains(stareActuala))
			System.out.println("Acest cuvant este acceptat de catre automat.");
		else
			System.out.println("Acest cuvant nu este acceptat de catre automat.");
	}

	public String Verificare(ArrayList<Arc> arce, char lit, String stareInit) {
		String stareActuala = stareInit;
		for (int i = 0; i < arce.size(); i++) {
			if (arce.get(i).getSt().equals(stareInit) && arce.get(i).getSimbolArc().equals(Character.toString(lit))) {
				stareActuala = arce.get(i).getDr();

			}
		}
		return stareActuala;

	}

	public static void serialize(Automat obj, String sursa) {
		try {
			FileOutputStream fis = new FileOutputStream(sursa);
			ObjectOutputStream obiect = new ObjectOutputStream(fis);
			obiect.writeObject(obj);
			fis.close();
			obiect.close();
		} catch (FileNotFoundException e) {
			System.err.println("Fisierul nu a fost gasit!");
			System.err.println("Exceptie:" + e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Eroare la scrierea in fisier!");
			e.printStackTrace();
		}

	}

	public static void citire(Automat a) {
		int nrStari = 0, nrStariFinale = 0, nrLitereAlfabet = 0, readInt, nrArce = 0;
		String readString = null;

		Scanner s = new Scanner(System.in);
		System.out.println("Dati numarul starilor: ");
		nrStari = Integer.parseInt(s.nextLine());
		for (int i = 0; i < nrStari; i++)
			readString = s.nextLine();
		a.addStare(readString);
		System.out.println("Dati numarul starilor finale: ");
		nrStariFinale = Integer.parseInt(s.nextLine());
		System.out.println("Dati numarul de Litere: ");
		nrLitereAlfabet = Integer.parseInt(s.nextLine());
		System.out.println("Dati starea initiala: ");
		readString = s.nextLine();
		a.setStareInitiala(readString);
		for (int i = 0; i < nrStariFinale; i++) {
			System.out.println("Dati starea finala:");
			readString = s.nextLine();
			a.addStareFinala(readString);
		}
		System.out.println("Dati numarul de arce: ");
		nrArce = Integer.parseInt(s.nextLine());
		for (int i = 0; i < nrArce; i++) {
			Arc arc = new Arc();
			System.out.println("Stare stanga: ");
			readString = s.nextLine();
			arc.setSt(readString);

			System.out.println("Stare dreapta :");
			readString = s.nextLine();
			arc.setDr(readString);

			System.out.println("Merge prin litera: ");
			readString = s.nextLine();
			arc.setSimbolArc(readString);
			a.addArc(arc);

		}
		for (int i = 0; i < nrLitereAlfabet; i++) {
			System.out.println("Dati litera: ");
			readString = s.nextLine();
			a.addLiteraAlfabet(readString);
		}
		serialize(a, "fis.txt");

	}

	public boolean verificareAccesibilitateStare(String stare) {
		for (int i = 0; i < arce.size(); i++)
			if (arce.get(i).getDr().compareTo(stare)==0)
				return true;
		return false;
	}

	public String staredublet(String stare, ArrayList<Arc> arce, String lit) {
		for (Arc arc : arce) {
			if (stare.equals(arc.getSt()) && lit.equals(arc.getSimbolArc())) {
				return arc.getDr();
			}

		}
		return stare;
	}

	public void minimizare() {
		ArrayList<String> accesibile = new ArrayList<String>();
		// pas 1
		accesibile.add(stareInitiala);
		for (String stare : stari) {
			if (verificareAccesibilitateStare(stare) == true) {
				accesibile.add(stare);
			}
		}
		// pas 2
		String[][] tablou = new String[accesibile.size()][accesibile.size()];
		for (int i = 0; i < accesibile.size(); i++) {
			Arrays.fill(tablou[i], "-");
		}
		// pas 3
		for (int i = 0; i < accesibile.size(); i++) {
			for (int j = 0; j < accesibile.size(); j++) {
				if (i == j)
					tablou[i][j] = "q" + i;
				if (stariFinale.contains(accesibile.get(i)) && !stariFinale.contains(accesibile.get(j))) {
					tablou[i][j] = "" + "x";
					tablou[j][i] = "" + "x";
				}
			}
		}
		// pas 4
		boolean modificat = false;
		for (int i = 0; i < accesibile.size() - 1; i++) {
			for (int j = 0; j < accesibile.size(); j++) {
				for (String lit : alfabet) {
					if (tablou[i][j].compareTo("-") == 0 && (!stariFinale.contains(staredublet("q" + i, arce, lit))
							&& stariFinale.contains(staredublet("q" + j, arce, lit)))) {
						tablou[i][j] = "" + "x";
						modificat = true;
					}
				}
			}
		}
		while (modificat) {
			modificat = false;
			for (int i = 0; i < accesibile.size() - 1; i++) {
				for (int j = 0; j < accesibile.size(); j++) {
					for (String lit : alfabet) {
						if (tablou[i][j].compareTo("-") == 0
								&& tablou[accesibile.indexOf(staredublet("q" + i, arce, lit))][accesibile
										.indexOf(staredublet("q" + j, arce, lit))].compareTo("x") == 0) {
							tablou[i][j] = "" + "x";
							modificat = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < accesibile.size(); i++) {
			System.out.print("\n");
			for (int j = 0; j < accesibile.size(); j++) {
				System.out.print(tablou[i][j] + " ");
			}
		}
		Automat min = new Automat();
		for (int i = 0; i < accesibile.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (tablou[i][j].compareTo("-") == 0) {
					min.addStare("q" + j + ";q" + i);
				}
			}
		}
		for (String stareT : min.getStari()) {
			if (stareT.indexOf(this.getStareInitiala()) != -1) {
				min.setStareInitiala(stareT);
			}
		}
		for (String stareT : min.getStari()) {
			for(String stareF:stariFinale)
			if (stareT.indexOf(stareF) != -1&&!min.getStariFinale().contains(stareT)) {
				min.addStareFinala(stareT);
			}
		}
		for (String l : alfabet)
			min.addLiteraAlfabet(l);
		for (int i = 0; i < accesibile.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (tablou[i][j].compareTo("-") == 0) {
					for (String lit : alfabet) {
						Arc gigel = new Arc();
						gigel.setSt("q" + j + ";q" + i);
						gigel.setSimbolArc(lit);
						if (staredublet("q" + i, arce, lit).compareTo("q" + i) == 0) {
							gigel.setDr("q" + j + ";q" + i);
						} else if (staredublet("q" + i, arce, lit).compareTo("q" + j) == 0) {
							gigel.setDr("q" + j + ";q" + i);
						} else {
							String stareNegasita = staredublet("q" + i, arce, lit);
							for (String stareT : min.getStari()) {
								if (stareT.indexOf(stareNegasita) != -1) {
									gigel.setDr(stareT);
								}
							}

						}
						min.addArc(gigel);
					}
				}
			}
		}
		System.out.println(min);
		min.serialize(min, "minim.txt");
		String cuvant;
		boolean verificari = true;
		while (verificari) {
			System.out.println("Vreti sa verificati un cuvant? 1.DA 2.NU");
			int opt;
			Scanner s = new Scanner(System.in);
			opt = Integer.parseInt(s.nextLine());
			switch (opt) {
			case 1:
				System.out.println("Dati cuvantul pe care doriti sa il verificati:");
				cuvant = s.nextLine();
				min.verificare(cuvant);
				break;
			case 2:
				System.out.println("La revedere!");
				verificari = false;
				break;

			default:
				System.out.println("Nu avem aceasta optiune.");
				break;
			}
		}
	}

}