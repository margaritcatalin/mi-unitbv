package testArhitectura;

import buffere.Buffer;
import clienti.Client;
import producatori.Producator;

public class TestSincronizare1 {

	public static void main(String[] args) {
		Buffer b = new Buffer();
		Producator p1 = new Producator(b);
		Client c1 = new Client(b);
		p1.start();
		c1.start();

	}

}
