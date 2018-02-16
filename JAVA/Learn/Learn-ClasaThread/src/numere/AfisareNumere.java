package numere;

public class AfisareNumere extends Thread{
	private int a, b, pas;

	public AfisareNumere(int a, int b, int pas) {
		this.a = a;
		this.b = b;
		this.pas = pas;
	}

	public void run() {
		for (int i = a; i <= b; i += pas) {
			System.out.print(i + " ");
		}
	}
}
