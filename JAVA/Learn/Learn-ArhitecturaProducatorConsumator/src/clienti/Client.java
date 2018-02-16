package clienti;

import buffere.Buffer;

public class Client extends Thread {
	private Buffer buffer;

	public Client(Buffer b) {
		buffer = b;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = buffer.get();
			System.out.println("Consumatorul a luat:\t" + value);
		}
	}
}
