package atentionari;

import java.awt.Toolkit;
import java.util.TimerTask;

public class Atentie extends TimerTask {
	public void run() {
		Toolkit.getDefaultToolkit().beep();
		System.out.print(".");
	}
}
