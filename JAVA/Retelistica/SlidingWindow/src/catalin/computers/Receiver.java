package catalin.computers;

import java.util.Random;

import catalin.jeton.Message;

public class Receiver implements Runnable{

	private boolean fWasZero = false;
	private Message m;
	private StringBuilder stringBuilder;
	public Receiver(Message m){
		this.m = m;
		stringBuilder = new StringBuilder();
		new Thread (this, "Receiver").start();
	}
	
	@Override
	
	public void run() {
		
		Random rnd = new Random();
		loop:
		while(m.getFIN()!=1){
			
			m.waitForSender();
			m.setSYN(1);
			int random = rnd.nextInt(4);
			
			m.setF(random);

			if(!fWasZero || random != 0){
				if(random != 0){
					fWasZero = false;
				}
				else{
					fWasZero = true;
				}
				stringBuilder.append(m.getMessage());
				System.out.println("-" + stringBuilder.toString());
				int x = m.getX();
				x++;
				m.setX(x);
			}
			m.setMessage("");
			if(m.getFIN()==1){
				break loop;
			}
			m.sendToSender();
		}
		
	}
}
