
public class TestThreadGroup {
	static class Dummy implements Runnable {
		@Override
		public void run() {
			while (true)
				Thread.yield();

		}
	}

	public static void main(String[] args) {
		java.awt.Frame f=new java.awt.Frame("Test");
		new Thread(new Dummy(),"Fir de test").start();
		Thread firCurent=Thread.currentThread();
		ThreadGroup grupCurent=firCurent.getThreadGroup();
		int n=grupCurent.activeCount();
		Thread[] lista=new Thread[n];
		grupCurent.enumerate(lista);
		for(int i=0;i<n;i++)
			System.out.println("Thread #"+i+"="+lista[i].getName());

	}

}
