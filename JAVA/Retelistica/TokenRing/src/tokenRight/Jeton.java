package tokenRight;

import java.util.Random;

public class Jeton {
	private String mesaj;
	private String ipSursa;
	private String ipDestinatie;
	private boolean disponibilitate;
	private boolean ajunsLaDestinatie;
	private boolean ajunsLaSursa=false;

	public Jeton(String mesaj, String ipSursa, String ipDestinatie, boolean disponibilitate, boolean destinatie) {
		this.mesaj = mesaj;
		this.ipSursa = ipSursa;
		this.ipDestinatie = ipDestinatie;
		this.disponibilitate = disponibilitate;
		this.ajunsLaDestinatie=destinatie;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

	public String getIpSursa() {
		return ipSursa;
	}

	public void setIpSursa(String ipSursa) {
		this.ipSursa = ipSursa;
	}

	public String getIpDestinatie() {
		return ipDestinatie;
	}

	public void setIpDestinatie(String ipDestinatie) {
		this.ipDestinatie = ipDestinatie;
	}

	public boolean isDisponibil() {
		return disponibilitate;
	}

	public synchronized void take() throws InterruptedException {
		disponibilitate = true;
		Thread.sleep(500);
	}

	public synchronized void drop() {
		disponibilitate = false;
		notifyAll();
	}

	public boolean isAjunsLaDestinatie() {
		return ajunsLaDestinatie;
	}

	public void setAjunsLaDestinatie(boolean ajunsLaDestinatie) {
		this.ajunsLaDestinatie = ajunsLaDestinatie;
	}

	public void changeMessage() {
		Random r = new Random();
		if (this.isAjunsLaDestinatie() == false) {
			this.setMesaj(this.mesaj + r.nextInt(10));
		}
	}

	public boolean isAjunsLaSursa() {
		return ajunsLaSursa;
	}

	public void setAjunsLaSursa(boolean ajunsLaSursa) {
		this.ajunsLaSursa = ajunsLaSursa;
	}

	@Override
	public String toString() {
		return "Jeton [mesaj=" + mesaj + ", ipSursa=" + ipSursa + ", ipDestinatie=" + ipDestinatie + "]";
	}
	
}
