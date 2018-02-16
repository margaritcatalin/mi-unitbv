package testAlarma;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import atentionari.Atentie;
import atentionari.Alarma;
public class TestTimer {

	public static void main(String[] args) {
		final Timer t1 = new Timer();
		t1.scheduleAtFixedRate(new Atentie(), 0, 1 * 1000);
		Timer t2 = new Timer();
		t2.schedule(new TimerTask() {
			public void run() {
				System.out.println("S-au scurs 10 secunde.");
				t1.cancel();
			}
		}, 10 * 1000);
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,22);
		calendar.set(Calendar.MINUTE,1);
		calendar.set(Calendar.SECOND,0);
		Date ora=calendar.getTime();
		Timer t3=new Timer();
		t3.schedule(new Alarma("Toti copii la culcare!"), ora);
	}
}
