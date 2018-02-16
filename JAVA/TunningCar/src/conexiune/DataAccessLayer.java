package conexiune;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Masini;
import model.Masinidetinute;
import model.User;
import utils.States;

public class DataAccessLayer {
	EntityManagerFactory factory = null;
	EntityManager em = null;

	public DataAccessLayer() {
		factory = Persistence.createEntityManagerFactory("TunningCar");
		em = factory.createEntityManager();
	}

	public void register() {
		em.getTransaction().begin();
		User u = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("------------Register------------");
		System.out.println("Username:");
		String usr = sc.nextLine();
		System.out.println("Password:");
		String pass = sc.nextLine();
		u.setUsername(usr);
		u.setPassword(pass);
		u.setAdministrator(0);
		em.persist(u);
		em.getTransaction().commit();
	}

	public User login(User l, Scanner sc) {
		try {
			System.out.println("------------Login------------");
			System.out.println("Username:");
			String usr = sc.nextLine();
			System.out.println("Password:");
			String pass = sc.nextLine();
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1 AND u.password= ?2",
					User.class);
			query.setParameter(1, usr);
			query.setParameter(2, pass);
			l = (User) query.getSingleResult();
			return l;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void changePassword(User u, Scanner sc) {
		if (null != em) {
			EntityTransaction updateTransaction = em.getTransaction();
			System.out.println(u.getUsername().toString() + "  " + u.getPassword().toString());
			System.out.println("Introduceti noua parola:");
			String newpassword = sc.nextLine();
			updateTransaction.begin();
			Query query = em.createQuery("UPDATE User u SET u.password = ?1 " + "WHERE u.idUser = ?2");
			query.setParameter(1, newpassword);
			query.setParameter(2, u.getIdUser());
			int updateCount = query.executeUpdate();
			if (updateCount > 0) {
				System.out.println("Parola a fost schimbata cu succes!");
			}
			updateTransaction.commit();
		}
	}

	public Masini cautareMarca(String denumire) {
		try {
			Masini car = new Masini();
			TypedQuery<Masini> query = em.createQuery("SELECT c FROM Masini c WHERE c.marca = ?1 ", Masini.class);
			query.setParameter(1, denumire);
			car = (Masini) query.getSingleResult();
			return car;
		} catch (NoResultException e) {
			System.out.println("Masina cu marca" + denumire + " nu exista.");
			return null;
		}
	}

	public void setDetinator(int admin) {
		if (admin > 0) {
			User u = new User();
			em.getTransaction().begin();
			Masinidetinute md = new Masinidetinute();
			Scanner sc = new Scanner(System.in);
			System.out.println("------------Seteaza detinatorul------------");
			u = null;
			while (u == null) {
				System.out.println("Username:");
				String usr = sc.nextLine();
				try {
					TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1", User.class);
					query.setParameter(1, usr);
					u = (User) query.getSingleResult();
				} catch (NoResultException e) {
					u = null;
					System.out.println("Aceast user nu exista in baza de date!");
				}
			}
			md.setUser(u);
			masiniExistente();
			Masini car = new Masini();
			car = null;
			while (car == null) {
				System.out.println("Introdu id masinii:");
				int cautare = Integer.parseInt(sc.nextLine());
				try {
					TypedQuery<Masini> query = em.createQuery("SELECT m FROM Masini m WHERE m.idMasina = ?1 ",
							Masini.class);
					query.setParameter(1, cautare);
					car = (Masini) query.getSingleResult();
				} catch (NoResultException e) {
					car = null;
					System.out.println("Aceasta masina nu exista in baza de date!");
				}
			}
			md.setMasini(car);
			em.persist(md);
			em.getTransaction().commit();
		} else
			System.out.println("Nu aveti acces la aceasta functie!");
	}

	public void masiniDetinute(User u) {
		TypedQuery<Masini> query = em.createQuery(
				"SELECT mo FROM Masinidetinute md inner join md.masini mo inner join md.user ud WHERE md.user = ?1 ",
				Masini.class);
		query.setParameter(1, u);
		List<Masini> rezultat = query.getResultList();
		if (rezultat.size() == 0)
			System.out.println("Momentan nu detineti nicio masina");
		else
			for (Masini car : rezultat) {
				System.out.println(car.toString());
			}
	}

	public void masiniExistente() {
		TypedQuery<Masini> query = em.createQuery("SELECT m FROM Masini m", Masini.class);
		List<Masini> rezultat = query.getResultList();
		if (rezultat.size() == 0)
			System.out.println("Nu sunt masini in baza de date!");
		else
			for (Masini car : rezultat) {
				System.out.println(car.toString());
			}
	}

	public void adaugaMasina(int admin) {
		if (admin > 0) {
			em.getTransaction().begin();
			Masini car = new Masini();
			Scanner sc = new Scanner(System.in);
			System.out.println("------------Introducere masini------------");
			System.out.println("Marca:");
			car.setMarca(sc.nextLine());
			System.out.println("Modelul masinii:");
			car.setModel(sc.nextLine());
			System.out.println("Introdu \'Benzina\' daca motorul functioneaza pe benzina.\n"
					+ "Introdu \'Diesel\' daca motorul functioneaza pe motorina.\n"
					+ "Introdu \'Electric\' daca masina este electrica.\n"
					+ "Introdu \'Hibrid\' daca masina ta este hibrid.");
			boolean introducere = true;
			while (introducere) {
				switch (sc.nextLine().toLowerCase()) {
				case "benzina": {
					car.setCombustibil("benzina");
					introducere = false;
					break;
				}
				case "diesel": {
					car.setCombustibil("diesel");
					introducere = false;
					break;
				}
				case "electric": {
					car.setCombustibil("electric");
					introducere = false;
					break;
				}
				case "hibrid": {
					car.setCombustibil("hibrid");
					introducere = false;
					break;
				}
				default: {
					System.out.println("Nu poti introduce un alt tip de combustibil");
					break;
				}
				}
			}
			System.out.println(
					"Introdu \'Fata\' daca are transmisie fata.\n" + "Introdu \'Spate\' daca are transmisie spate.");
			introducere = true;
			while (introducere) {
				switch (sc.nextLine().toLowerCase()) {
				case "fata": {
					car.setTransmisie("fata");
					introducere = false;
					break;
				}
				case "spate": {
					car.setTransmisie("spate");
					introducere = false;
					break;
				}
				default: {
					System.out.println("Poti introduce doar optiunile existente!");
					break;
				}
				}
			}
			System.out.println("Culoare:");
			car.setCuloare(sc.nextLine());
			System.out.println("Introdu capacitatea cilindrica:");
			car.setCapacitate_cilindrica(Integer.parseInt(sc.nextLine()));
			System.out.println("Introdu \'Automata\' daca masina are cutie de viteza automata.\n"
					+ "Introdu \'Manuala\' daca masina are cutie de viteza manuala.");
			introducere = true;
			while (introducere) {
				switch (sc.nextLine().toLowerCase()) {
				case "automata": {
					car.setCutie_de_viteze("automata");
					introducere = false;
					break;
				}
				case "manuala": {
					car.setCutie_de_viteze("manuala");
					introducere = false;
					break;
				}
				default: {
					System.out.println("Poti introduce doar optiunile existente!");
					break;
				}
				}
			}
			System.out.println("Introdu \'Non-Euro\' daca norma de puluare este non-euro.\n"
					+ "Introdu \'Euro1\' daca norma de poluare este euro 1.\n"
					+ "Introdu \'Euro2\' daca norma de poluare este euro 2.\n"
					+ "Introdu \'Euro3\' daca norma de poluare este euro 3.\n"
					+ "Introdu \'Euro4\' daca norma de poluare este euro 4.\n"
					+ "Introdu \'Euro5\' daca norma de poluare este euro 5.\n"
					+ "Introdu \'Euro6\' daca norma de poluare este euro 6.");
			introducere = true;
			while (introducere) {
				switch (sc.nextLine().toLowerCase()) {
				case "non-euro": {
					car.setNorma_de_poluare("Non-euro");
					introducere = false;
					break;
				}
				case "euro1": {
					car.setNorma_de_poluare("Euro1");
					introducere = false;
					break;
				}
				case "euro2": {
					car.setNorma_de_poluare("Euro2");
					introducere = false;
					break;
				}
				case "euro3": {
					car.setNorma_de_poluare("Euro3");
					introducere = false;
					break;
				}
				case "euro4": {
					car.setNorma_de_poluare("Euro4");
					introducere = false;
					break;
				}
				case "euro5": {
					car.setNorma_de_poluare("Euro5");
					introducere = false;
					break;
				}
				case "euro6": {
					car.setNorma_de_poluare("Euro6");
					introducere = false;
					break;
				}
				default: {
					System.out.println("Poti introduce doar optiunile existente!");
					break;
				}
				}
			}
			System.out.println("Introdu \'Da\' daca masina are aer conditionat.\n"
					+ "Introdu \'Nu\' daca masina nu are aer conditionat.");
			introducere = true;
			while (introducere) {
				switch (sc.nextLine().toLowerCase()) {
				case "da": {
					car.setAer_conditionat(1);
					introducere = false;
					break;
				}
				case "nu": {
					car.setAer_conditionat(0);
					introducere = false;
					break;
				}
				default: {
					System.out.println("Poti introduce doar optiunile existente!");
					break;
				}
				}
			}
			em.persist(car);
			em.getTransaction().commit();
		} else
			System.out.println("Nu aveti acces la aceasta functie!");
	}

	public void tunninCar(User u) {
		em.getTransaction().begin();
		TypedQuery<Masini> query = em.createQuery(
				"SELECT mo FROM Masinidetinute md inner join md.masini mo inner join md.user ud WHERE md.user = ?1 ",
				Masini.class);
		query.setParameter(1, u);
		List<Masini> rezultat = query.getResultList();
		if (rezultat.size() == 0)
			System.out.println("Momentan nu detineti nicio masina");
		else {
			for (Masini masina : rezultat) {
				System.out.println(masina.toString());
				Scanner sc = new Scanner(System.in);
				Masini car = new Masini();
				car = null;
				while (car == null) {
					System.out.println("Introduceti id-ul masinii pe care doriti sa o modoficati:");
					int cautare = Integer.parseInt(sc.nextLine());
					try {
						TypedQuery<Masini> query1 = em.createQuery("SELECT m FROM Masini m WHERE m.idMasina = ?1 ",
								Masini.class);
						query1.setParameter(1, cautare);
						car = (Masini) query1.getSingleResult();
					} catch (NoResultException e) {
						car = null;
						System.out.println("Aceasta masina nu exista in baza de date!");
					}
				}
				System.out.println("------------Customizare masina------------");
				System.out.println("Introdu \'Fata\' daca are transmisie fata.\n"
						+ "Introdu \'Spate\' daca are transmisie spate.");
				boolean introducere = true;
				while (introducere) {
					switch (sc.nextLine().toLowerCase()) {
					case "fata": {
						car.setTransmisie("fata");
						introducere = false;
						break;
					}
					case "spate": {
						car.setTransmisie("spate");
						introducere = false;
						break;
					}
					default: {
						System.out.println("Poti introduce doar optiunile existente!");
						break;
					}
					}
				}
				System.out.println("Culoare:");
				car.setCuloare(sc.nextLine());
				System.out.println("Introdu capacitatea cilindrica:");
				car.setCapacitate_cilindrica(Integer.parseInt(sc.nextLine()));
				System.out.println("Introdu \'Automata\' daca masina are cutie de viteza automata.\n"
						+ "Introdu \'Manuala\' daca masina are cutie de viteza manuala.");
				introducere = true;
				while (introducere) {
					switch (sc.nextLine().toLowerCase()) {
					case "automata": {
						car.setCutie_de_viteze("automata");
						introducere = false;
						break;
					}
					case "manuala": {
						car.setCutie_de_viteze("manuala");
						introducere = false;
						break;
					}
					default: {
						System.out.println("Poti introduce doar optiunile existente!");
						break;
					}
					}
				}
				System.out.println("Introdu \'Non-Euro\' daca norma de puluare este non-euro.\n"
						+ "Introdu \'Euro1\' daca norma de poluare este euro 1.\n"
						+ "Introdu \'Euro2\' daca norma de poluare este euro 2.\n"
						+ "Introdu \'Euro3\' daca norma de poluare este euro 3.\n"
						+ "Introdu \'Euro4\' daca norma de poluare este euro 4.\n"
						+ "Introdu \'Euro5\' daca norma de poluare este euro 5.\n"
						+ "Introdu \'Euro6\' daca norma de poluare este euro 6.");
				introducere = true;
				while (introducere) {
					switch (sc.nextLine().toLowerCase()) {
					case "non-euro": {
						car.setNorma_de_poluare("Non-euro");
						introducere = false;
						break;
					}
					case "euro1": {
						car.setNorma_de_poluare("Euro1");
						introducere = false;
						break;
					}
					case "euro2": {
						car.setNorma_de_poluare("Euro2");
						introducere = false;
						break;
					}
					case "euro3": {
						car.setNorma_de_poluare("Euro3");
						introducere = false;
						break;
					}
					case "euro4": {
						car.setNorma_de_poluare("Euro4");
						introducere = false;
						break;
					}
					case "euro5": {
						car.setNorma_de_poluare("Euro5");
						introducere = false;
						break;
					}
					case "euro6": {
						car.setNorma_de_poluare("Euro6");
						introducere = false;
						break;
					}
					default: {
						System.out.println("Poti introduce doar optiunile existente!");
						break;
					}
					}
				}
				System.out.println("Introdu \'Da\' daca masina are aer conditionat.\n"
						+ "Introdu \'Nu\' daca masina nu are aer conditionat.");
				introducere = true;
				while (introducere) {
					switch (sc.nextLine().toLowerCase()) {
					case "da": {
						car.setAer_conditionat(1);
						introducere = false;
						break;
					}
					case "nu": {
						car.setAer_conditionat(0);
						introducere = false;
						break;
					}
					default: {
						System.out.println("Poti introduce doar optiunile existente!");
						break;
					}
					}
				}
				em.persist(car);
				em.getTransaction().commit();
			}
		}
	}

	public void removeCar(int admin, Scanner sc) {
		if (admin > 0) {
			System.out.print("---------------Scoate masina-------------");
			masiniExistente();
			System.out.print("Introdu id masinii:");
			int cautare = Integer.parseInt(sc.nextLine());
			Masini car = new Masini();
			car = null;
			try {
				TypedQuery<Masini> query = em.createQuery("SELECT m FROM Masini m WHERE m.idMasina = ?1 ",
						Masini.class);
				query.setParameter(1, cautare);
				car = (Masini) query.getSingleResult();
			} catch (NoResultException e) {
				System.out.println("Aceasta masina nu exista in baza de date!");
			}
			if (car != null) {
				Masinidetinute card = new Masinidetinute();
				card = null;
				TypedQuery<Masinidetinute> query1 = em
						.createQuery("SELECT md FROM Masinidetinute md WHERE md.masini = ?1 ", Masinidetinute.class);
				query1.setParameter(1, car);
				card = (Masinidetinute) query1.getSingleResult();
				if (card != null)
					em.getTransaction().begin();
				em.remove(card);
				em.getTransaction().commit();
				car.removeMasinidetinute(card);
				em.getTransaction().begin();
				em.remove(car);
				em.getTransaction().commit();
			}
		} else
			System.out.println("Nu aveti acces la aceasta functie!");
	}
}
