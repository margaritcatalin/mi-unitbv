package catalin.computers;

import catalin.jeton.Message;

public class Sender implements Runnable{

	private Message m;
	private String message;
	
	public Sender(Message m, String message){
		this.m = m;
		this.message = message;
		new Thread (this, "Sender").start();;
	}
	
	@Override	
	public void run() {
		m.sendFirstMessage();
		
		for(int i = 0 ; i < message.length();){
			m.waitForReceiver();
			if(m.getF() == 0){
				m.cannotSend();
				continue;
			}
			int x = m.getX() - 1;
			x += m.getF();
			m.setX(x);
			if(i + m.getF() > message.length()){
				m.setMessage(message.substring(i, message.length()));
				m.setF(1);
			}
			else{				
				m.setMessage(message.substring(i, i+m.getF()));
			}
			i += m.getF();
			m.sendToReceiver();
		}
		m.setFIN(1);
	}
}
