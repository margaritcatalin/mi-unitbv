package producatori;

import java.io.DataOutputStream;
import java.io.IOException;

public class Producator extends Thread {
	private DataOutputStream out;

	public Producator(DataOutputStream out) {
		this.out = out;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				out.writeInt(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Producatorul a pus:\t" + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
