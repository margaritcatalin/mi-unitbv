package testNumere;

import numere.AfisareNumere;

public class TestThread {
	public static void main(String[] args) {
		AfisareNumere fir1, fir2;
		fir1 = new AfisareNumere(0, 100, 5);
		fir2 = new AfisareNumere(100, 200, 10);
		fir1.start();
		fir2.start();
	}
}
