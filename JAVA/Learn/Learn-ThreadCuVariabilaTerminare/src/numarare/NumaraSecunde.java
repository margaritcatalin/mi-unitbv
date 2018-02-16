package numarare;

public class NumaraSecunde extends Thread{
public int sec=0;
public boolean executie=true;
public void run() {
	while(executie) {
		try {
			Thread.sleep(1000);
			sec++;
			System.out.println(".");
		}catch(InterruptedException e) {
			
		}
	}
}
}
