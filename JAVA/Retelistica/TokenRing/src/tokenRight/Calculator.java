package tokenRight;

import tokenRight.Ip;

public class Calculator implements Runnable {
	private String ip;
	private String buffer;
	private Jeton jeton;

	public Calculator() {
		this.ip = Ip.generateNewIp();
		this.buffer = "";
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

	@Override
	public String toString() {
		return "Calculator: " + ip;
	}

	@Override
	public void run() {
		try {
			boolean running=true;
			while (running) {
				System.out.println(this + " " + "thinking");
				Thread.currentThread();
				Thread.sleep(1000);
				jeton.take();
				Thread.currentThread();
				Thread.sleep(1000);
				System.out.println(this + " " + "verify");
				Thread.currentThread();
				Thread.sleep(1000);
				if (jeton.getIpDestinatie().compareTo(ip) == 0 && jeton.isAjunsLaDestinatie() == false) {
					System.out.println("Mesajul a ajuns la destinatie!");
					this.setBuffer(jeton.getMesaj());
					System.out.println("Calculatorul " + this.getIp() + " a primit mesajul:" + this.getBuffer());
					jeton.setAjunsLaDestinatie(true);
				}
				if (jeton.getIpSursa().compareTo(ip) == 0 && jeton.isAjunsLaDestinatie() == true) {
					System.out.println("Calculatorul " + this.getIp() +" Jetonul a ajuns inapoi la sursa");
					jeton.setAjunsLaSursa(true);
					Thread.sleep(3000);
					running = false;
				}
				jeton.drop();
				Thread.currentThread();
				Thread.sleep(1000);
				if (!(jeton.getIpSursa().compareTo(ip) == 0))
					running = false;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void setJeton(Jeton jeton) {
		this.jeton = jeton;
	}

}
