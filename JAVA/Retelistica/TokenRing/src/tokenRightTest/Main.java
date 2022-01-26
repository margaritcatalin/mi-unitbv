package tokenRightTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tokenRight.Calculator;
import tokenRight.Jeton;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Calculator> listaCalculatoare = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Calculator calculator = new Calculator();
			listaCalculatoare.add(calculator);
		}

		while (true) {
			ExecutorService executorService = null;
			Random r = new Random();
			int indexCalculatorSursa = r.nextInt(10);
			int indexCalculatorDestinatie = r.nextInt(10);
			while (listaCalculatoare.get(indexCalculatorSursa).getIp()
					.compareTo(listaCalculatoare.get(indexCalculatorDestinatie).getIp()) == 0) {
				indexCalculatorDestinatie = r.nextInt(10);
			}
			String mesaj = "Hello by " + listaCalculatoare.get(indexCalculatorSursa).getIp();
			Jeton jeton = new Jeton(mesaj, listaCalculatoare.get(indexCalculatorSursa).getIp(),
					listaCalculatoare.get(indexCalculatorDestinatie).getIp(), false, false);
			System.out.println(jeton);
			try {
				executorService = Executors.newFixedThreadPool(10);
				for (Calculator calculator : listaCalculatoare) {
					calculator.setJeton(jeton);
					executorService.execute(calculator);
				}
			} finally {
				executorService.shutdown();
				while (!executorService.isTerminated()) {
					Thread.sleep(1000);
				}
			}

		}
	}
}
