package catalin.sort.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import catalin.sort.dao.interfaces.INumarDAO;
import catalin.sort.entities.Numar;
import catalin.sort.util.EntityDAOImplFactory;
import catalin.sort.util.LinearSort;

public class Main {
	private static int choice;
	public static final String PERSISTANCE_UNIT_NAME1 = "/catalin/sort/util/postgres-hibernate1.cfg.xml";
	public static final String PERSISTANCE_UNIT_NAME2 = "/catalin/sort/util/postgres-hibernate2.cfg.xml";
	private static INumarDAO numarDao = EntityDAOImplFactory.createNewNumarDAOImpl(PERSISTANCE_UNIT_NAME1,PERSISTANCE_UNIT_NAME2);
	private static List<Integer> getRand(Integer size) {
		List<Integer> a = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			a.add(rand.nextInt(size));
		}
		return a;
	}

	public static void main(String[] args) {
		Numar nr = new Numar();
		System.out.print("Introduceti dimensiunea vectorului:");
		Scanner sc = new Scanner(System.in);
		Integer size = sc.nextInt();
		do {
			System.out.println("\n1. Sort ");
			System.out.println("2. List ");
			System.out.println("3. Exit ");
			System.out.println("Enter your choice ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Integer> array = new LinearSort(getRand(size), size).sort();
				for (Integer integer : array) {
					System.out.print(integer+" ");
				}
				for (int i = 0; i < array.size() / 2; i++) {
					nr.setNumar(array.get(i));
					numarDao.insertBb1Numar(nr);
				}
				for (int i = array.size() / 2; i < array.size(); i++) {
					nr.setNumar(array.get(i));
					numarDao.insertBb2Numar(nr);
				}
				break;
			case 2:
				numarDao.findAllNumar();
				break;
			}
		} while (choice != 3);
	}
}
