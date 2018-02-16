import java.io.Serializable;
import java.util.ArrayList;

public class Automat implements Serializable{
    private String stareInitiala;
    private ArrayList stariFinale = new ArrayList<String>();
    private ArrayList alfabet = new ArrayList<String>();
    private ArrayList arce = new ArrayList<Arc>();
	public Automat(String stareInitiala, ArrayList stariFinale, ArrayList alfabet,
			ArrayList arce) {
		super();
		this.stareInitiala = stareInitiala;
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
	public ArrayList getStariFinale() {
		return stariFinale;
	}
	public void setStariFinale(ArrayList stariFinale) {
		this.stariFinale = stariFinale;
	}
	public ArrayList getAlfabet() {
		return alfabet;
	}
	public void setAlfabet(ArrayList alfabet) {
		this.alfabet = alfabet;
	}
	public ArrayList getArce() {
		return arce;
	}
	public void setArce(ArrayList arce) {
		this.arce = arce;
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
		return "Automat [stareInitiala=" + stareInitiala + ", stariFinale=" + stariFinale + ", alfabet=" + alfabet
				+ ", arce=" + arce + "]";
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
	int ok=0;
	for (int i = 0; i < arce.size(); i++) {
		if (arce.get(i).getSt().equals(stareInit) && arce.get(i).getSimbolArc().equals(Character.toString(lit)))
		{	
			stareActuala = arce.get(i).getDr();
			ok=1;
		
		}
	}
	if(ok==0)
		stareActuala = "Nu exista cale prin acest simbol";
	return stareActuala;

}
}