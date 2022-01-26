package catalin.jeton;

public class Message {
	private int x;
	private int ACK;
	private int SYN;
	private int f;
	private int FIN;
	private String message;
	boolean messageSent = false;

	public Message() {
		super();
		x = 0;
		ACK = 1;
		SYN = 0;
		f = 0;
		FIN = 0;
		message = new String();
	}

	public Message(int x, int aCK, int sYN, int f, int fIN) {
		super();
		this.x = x;
		ACK = aCK;
		SYN = sYN;
		this.f = f;
		FIN = fIN;
		message = new String();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getACK() {
		return ACK;
	}

	public void setACK(int aCK) {
		ACK = aCK;
	}

	public int getSYN() {
		return SYN;
	}

	public void setSYN(int sYN) {
		SYN = sYN;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getFIN() {
		return FIN;
	}

	public void setFIN(int fIN) {
		FIN = fIN;
	}

	public synchronized void sendFirstMessage() {
		System.out.println("first msg");
		messageSent = true;
		notifyAll();
	}

	public synchronized void sendToReceiver() {
		messageSent = true;
		System.out.println("sendToReceiver");
		notifyAll();
	}

	public synchronized void sendToSender() {
		messageSent = false;
		System.out.println("sendToSender");
		notifyAll();
	}

	public synchronized void waitForReceiver() {
		while (messageSent == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public synchronized void waitForSender() {
		while (messageSent == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public synchronized void cannotSend() {
		messageSent = true;
		notifyAll();
		System.out.println("f == 0 , waiting");
	}

}
