package consumatori;

import java.io.DataInputStream;
import java.io.IOException;

public class Consumator extends Thread {
	private DataInputStream in;

	public Consumator(DataInputStream in) {
		this.in = in;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			try {
				value = in.readInt();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Consumatorul a primit:\t" + value);
		}
	}
}
