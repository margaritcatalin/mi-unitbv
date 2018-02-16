package egoisti;

public class FirEgoist extends Thread {
	public FirEgoist(String nume) {
		super(nume);
	}

	public void run() {
		int i = 0;
		while (i < 100000) {
			i++;
			if (i % 100 == 0) {
				System.out.println(getName() + " a ajuns la " + i);
				yield();
			}
		}
	}
}
