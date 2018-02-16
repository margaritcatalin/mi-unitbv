package testBeepere;

import beepere.Beeper;

public class TestDaemon {
	public static void main(String[] args) throws java.io.IOException {
		Thread t = new Thread(new Beeper());
		t.setDaemon(true);
		t.start();
		System.out.println("Apasa enter...");
		System.in.read();
	}
}
