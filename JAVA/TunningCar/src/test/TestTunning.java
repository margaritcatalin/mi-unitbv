package test;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import conexiune.DataAccessLayer;
import model.User;
import utils.States;

public class TestTunning {
	public static void printNotLoggedMenu() {
		System.out.println("Introdu \'1\' pentru inregistrare.\n" + "Introdu \'2\' pentru autentificare.\n"
				+ "Introdu \'0\' pentru a iesi.");
	}

	public static void printLoggedMenu(int admin) {
		System.out.println("Introdu \'3\' pentru a vedea masinile detinute.\n"
				+ "Introdu \'4\' pentru a cauta o masina dupa marca.\n"
				+ "Introdu \'5\' pentru a modifica o masina.\n");
		if (admin > 0) {
			System.out.println("Introdu \'6\' pentru a adauga o masina.\n" + "Introdu \'7\' pentru a scoate o masina.\n"
					+ "Introdu \'8\' pentru a atribui un detinator unei masini.\n");
		}
		System.out.println(
				"Enter \'2\' to change your password.\n" + "Enter \'1\' to log out.\n" + "Enter \'0\' to quit.\n");
	}

	public static void main(String[] args) {
		DataAccessLayer dal = new DataAccessLayer();
		Scanner sc = new Scanner(System.in);
		States state = States.WAITING;
		User l = new User();
		boolean start = true;
		while (start) {
			switch (state) {
			case WAITING: {
				state = States.NOTLOGGED;
				break;
			}
			case NOTLOGGED: {
				printNotLoggedMenu();
				switch (Integer.parseInt(sc.nextLine())) {
				case 0: {
					state = States.EXIT;
					break;
				}
				case 1: {
					dal.register();
					state = States.SIGNUP;
					break;
				}
				case 2: {
					l = dal.login(l, sc);
					if (l == null) {
						System.out.println("Datele dumneavoastra de utlizator nu stunt corecte!");
						state = States.NOTLOGGED;
					} else
						state = States.LOGGED;
					break;
				}
				default:
					System.out.println("Alegeti o optiune valida!");
					break;
				}
				break;
			}
			case SIGNUP: {
				state = States.NOTLOGGED;
				break;
			}
			case LOGGED: {
				printLoggedMenu(l.getAdministrator());
				switch (Integer.parseInt(sc.nextLine())) {
				case 0: {
					state = States.EXIT;
					break;
				}
				case 1: {
					System.out.println("V-ati deconectat cu succes!");
					state = States.NOTLOGGED;
					break;
				}
				case 2: {
					dal.changePassword(l, sc);
					System.out.println("Va rugam sa va autentificati!");
					state = States.NOTLOGGED;
					break;
				}
				case 3: {
					dal.masiniDetinute(l);
					break;
				}
				case 4: {
					System.out.println("Introduceti marca:");
					System.out.println(dal.cautareMarca(sc.nextLine()).toString());
					break;
				}
				case 5: {
					dal.tunninCar(l);
					break;
				}
				case 6: {
					dal.adaugaMasina(l.getAdministrator());
					break;
				}
				case 7: {
					dal.removeCar(l.getAdministrator(), sc);
					break;
				}
				case 8: {
					dal.setDetinator(l.getAdministrator());
					break;
				}
				default: {
					System.out.println("Alegeti o optiune valida!");
					break;
				}
				}
				break;
			}
			case EXIT: {
				System.out.println("La revedere!");
				start = false;
				break;
			}
			}
		}
	}
}
