package beepere;

public class Beeper implements Runnable {

	@Override
	public void run() {
		while (true) {
			java.awt.Toolkit.getDefaultToolkit().beep();
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
			}
		}
	}

}
