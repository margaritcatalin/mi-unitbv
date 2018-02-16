package test;

import java.util.Scanner;

import javax.persistence.EntityManager;

import conexiune.DataAccesLayer;
import model.User;

public class TestMagazin {
	public static void meniu(DataAccesLayer dal, User u, Scanner sc) {
		int optUser;
		boolean meniur = false;
		while (meniur == false) {
			meniur=true;
			System.out.println(
					"------------Meniu------------\n 1.Vezi produsele disponibile\n 2.Cauta un produs dupa cod produs\n3.Cauta un produs dupa denumire\n4.Plasease o comanda\n5.Vezi istoricul cumaparaturilor");
			if (u.getTip() >= 1) {
				System.out.println("------------Meniu Vanzator------------");
				System.out.println("\n6.Adauga un produs la vanzare\n7.Vezi produsele adaugate");
			}
			System.out.println("\n8.Schimba parola");
			System.out.println("\n9.Deconectare");
			optUser = Integer.parseInt(sc.nextLine());
			switch (optUser) {
			case 1: {
				dal.produseDisponibile();
				meniu(dal, u, sc);
				break;
			}
			case 2: {
				System.out.println("Cod_Produs:");
				int cautare = Integer.parseInt(sc.nextLine());
				dal.cautareCod(cautare);
				meniu(dal, u, sc);
				break;
			}
			case 3: {
				System.out.println("Denumire:");
				String cautare = sc.nextLine();
				dal.cautareDenumire(cautare);
				meniu(dal, u, sc);
				break;
			}
			case 4: {
				dal.comanda(u, sc);
				meniu(dal, u, sc);
				break;
			}
			case 5: {
				dal.istoricComenzi(u, sc);
				meniu(dal, u, sc);
				break;
			}
			case 6: {
				dal.adaugaProdus(u);
				meniu(dal, u, sc);
				break;
			}
			case 7: {
				dal.produseAdaugate(u);
				meniu(dal, u, sc);
				break;
			}
			case 8: {
				dal.changePassword(u, sc);
				meniu(dal, u, sc);
				break;
			}
			case 9: {
				dal.deconectare();
				break;
			}
			default: {
				System.out.println("Aceasta optiune nu exista!");
				meniur=false;
				break;
			}
			}
		}
	}

	public static void main(String[] args) {
		DataAccesLayer dal = new DataAccesLayer();
		Scanner sc = new Scanner(System.in);
		int opt;
		boolean first = false;
		while (first == false) {
			System.out.println("Nu sunteti autentificat!\n 1.Autentificare\n 2.Register");
			try {
				opt = Integer.parseInt(sc.nextLine());
				first = true;
				switch (opt) {
				case 1: {
					User u = new User();
					u = dal.login(u, sc);
					meniu(dal, u, sc);
					break;
				}
				case 2: {
					dal.register();
					System.out.println("Te-ai inregistrat! Te rugam sa te autentifici!");
					User u = new User();
					u = dal.login(u, sc);
					meniu(dal, u, sc);
					break;
				}
				default: {
					System.out.println("Aceasta optiune nu exista!");
					first = false;
					break;
				}
				}
			} catch (NumberFormatException ex) { // handle your exception
				System.out.println("Aceasta optiune nu exista!");
				first = false;
			}
		}
	}
}
