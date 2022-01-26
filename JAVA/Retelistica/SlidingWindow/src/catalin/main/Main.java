package catalin.main;

import catalin.computers.*;
import catalin.jeton.Message;

public class Main {

	public static void main(String[] args) {

		Message m = new Message();
		new Sender(m, "Test message!");
		new Receiver(m);

	}
}
