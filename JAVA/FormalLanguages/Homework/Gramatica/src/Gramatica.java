import java.util.*;
import java.io.*;

public class Gramatica {
	private String[] vt;
	private String[] vn;
	private String[] prodSt;
	private String[] prodDr;
	private String s;

	public Gramatica(String sursa) {
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader(sursa));
			String dateall = f.readLine();
			String[] date = dateall.split(";");
			vt = new String[date[0].split(",").length + 1];
			vn = new String[date[1].split(",").length + 1];
			s = new String();
			prodSt = new String[date[3].split(",").length];
			prodDr = new String[date[3].split(",").length];
			String[] sep = date[0].split(",");
			for (int i = 0; i < sep.length; i++) {
				this.setVn(i, sep[i]);
			}
			sep = date[1].split(",");
			for (int i = 0; i < sep.length; i++) {
				this.setVt(i, sep[i]);
			}
			this.setS(date[2]);
			sep = date[3].split(",");
			for (int i = 0; i < sep.length; i++) {
				String[] prod = sep[i].split("-");
				this.setProdSt(i, prod[0]);
				this.setProdDr(i, prod[1]);
			}
			verificare(this);
		} catch (FileNotFoundException e) {
			System.err.println("Fisierul nu a fost gasit!");
			System.err.println("Exceptie:" + e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Eroare la citirea din fisier!");
			e.printStackTrace();
		} finally {
			if (f != null) {
				try {
					f.close();
				} catch (IOException e) {
					System.out.println("Fisierul nu poate fi inchis!");
					e.printStackTrace();
				}
			}
		}
	}

	public void verificare(Gramatica gram) {
		if (gram.intersectia() && gram.simbolstart() && gram.productii()) {
			System.out.println("Dati numarul de cuvinte: ");
			Scanner sc = new Scanner(System.in);
			int nr = sc.nextInt();
			Random r = new Random();
			System.out.println("Introduceti de cate ori sa se verifice productiile: ");
			int gennr = sc.nextInt();
			for (int x = 0; x < nr; x++) {
				String cuv = "";
				cuv = gram.getS();
				boolean gen = true;
				int nrgen = 0;
				ArrayList<Integer> v = new ArrayList();
				while (gen) {
					boolean hasUppercase;
					hasUppercase = !cuv.equals(cuv.toLowerCase());
					for (int i = 0; i < prodSt.length; i++)
						while (hasUppercase) {
							v.clear();
							
							hasUppercase = !cuv.equals(cuv.toLowerCase());
							v = productiiAplicabile(cuv, prodSt);
							if (v.size() != 0)
							{
								int j = r.nextInt(v.size());
								cuv = Schimba(cuv, gram.getProdSt(v.get(j)), gram.getProdDr(v.get(j)));
								nrgen++;
							}
							if (nrgen == gennr) {
								gen = false;
								hasUppercase = false;
							}
							if (!hasUppercase || nrgen == gennr)
								gen = false;
						}

				}
				boolean hasUppercase = !cuv.equals(cuv.toLowerCase());
				if (!hasUppercase)
					System.out.println("Cuvant generat bun:" + cuv);
				else
					System.out.println("Cuvant generat rau:" + cuv);
			}
		} else {
			System.out.println("Gramatica nu este corecta!");
		}
	}

	public static ArrayList<Integer> productiiAplicabile(String cuv, String[] prodSt) {
		ArrayList<Integer> v = new ArrayList();
		for (int i = 0; i < prodSt.length; i++)
			if (cuv.contains(prodSt[i]))
				v.add(i);
		return v;
	}

	public static String Schimba(String cuvant, String prodSt, String prodDr) {
		int pos = cuvant.indexOf(prodSt);
		if (pos < 0) {
			return cuvant;
		}
		return cuvant.substring(0, pos) + prodDr + cuvant.substring(pos + prodSt.length());
	}

	public Boolean intersectia() {
		for (int i = 0; i < vn.length; i++)
			for (int j = 0; j < vt.length; j++)
				if (vn[i].equals(vt[j]))
					return false;
		return true;
	}

	public Boolean simbolstart() {
		for (int i = 0; i < vn.length; i++)
			if (s.equals(vn[i]))
				return true;
		return false;
	}

	public Boolean productii() {
		for (int i = 0; i < vn.length; i++)
			for (int j = 0; j < vn.length; j++)
				if (prodSt[i].contains(vn[j]))
					return true;
		return false;
	}

	public String[] getVt() {
		return vt;
	}

	public void setVt(int i, String c) {
		this.vt[i] = "";
		this.vt[i] = c;
	}

	public void setVn(int i, String vn) {
		this.vn[i] = "";
		this.vn[i] = vn;
	}

	public String getS() {
		return s;
	}

	public String getVn(int i) {
		return vn[i];
	}

	public String getVt(int i) {
		return vt[i];
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getProdDr(int dr) {
		return prodDr[dr];
	}

	public String getProdSt(int st) {
		return prodSt[st];
	}

	public void setProdDr(int i, String dr) {
		this.prodDr[i] = "";
		this.prodDr[i] = dr;
	}

	public void setProdSt(int i, String st) {
		this.prodSt[i] = "";
		this.prodSt[i] = st;
	}

	@Override
	public String toString() {
		return "Gramatica [vt=" + Arrays.toString(vt) + ", vn=" + Arrays.toString(vn) + ", prodSt="
				+ Arrays.toString(prodSt) + ", prodDr=" + Arrays.toString(prodDr) + ", s=" + s + "]";
	}

}
