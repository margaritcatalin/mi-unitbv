package Test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;


import model.Comanda;
import model.DetaliiComanda;
import model.Produs;
import model.User;

public class TestMagazin {
	public static void register(EntityManager em) {
		em.getTransaction().begin();
		User u = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("------------Creare Cont------------");
		System.out.println("Username:");
		String usr = sc.nextLine();
		System.out.println("Password:");
		String pass = sc.nextLine();
		u.setUsername(usr);
		u.setPassword(pass);
		u.setStatus(0);
		u.setVanzator(0);
		u.setBuget(50000);
		em.persist(u);
		em.getTransaction().commit();
	}

	public static User login(EntityManager em, User l,Scanner sc) {
		boolean cont = true;
		while (cont) {
			try {
				System.out.println("------------Autentificare------------");
				System.out.println("Username:");
				String usr = sc.nextLine();
				System.out.println("Password:");
				String pass = sc.nextLine();
				TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1 AND u.password= ?2",
						User.class);
				query.setParameter(1, usr);
				query.setParameter(2, pass);
				l = (User) query.getSingleResult();
				l.setStatus(1);
				em.getTransaction().begin();
				em.merge(l);
				em.getTransaction().commit();
				cont=false;
				
			} catch (NoResultException e) {
				System.out.println("Acest cont nu exista!");
			}
		}
		return l;
	}

	public static void adaugaProdus(EntityManager em, User l) {
		if (l.getVanzator() >= 1) {
			em.getTransaction().begin();
			Produs produs = new Produs();
			Scanner sc = new Scanner(System.in);
			System.out.println("------------Produs nou------------");
			System.out.println("Denumire:");
			String denumire = sc.nextLine();
			System.out.println("Pret:");
			int pret = Integer.parseInt(sc.nextLine());
			System.out.println("Cantitate:");
			int cantitate = Integer.parseInt(sc.nextLine());
			produs.setDenumire(denumire);
			produs.setPret(pret);
			produs.setStoc(cantitate);
			produs.setIdVanzator(Integer.parseInt(l.getId_User().toString()));
			em.persist(produs);
			em.getTransaction().commit();
		} else
			System.out.println();
	}

	public static void deconectare(EntityManager em, User u) {
		em.getTransaction().begin();
		u.setStatus(0);
		em.persist(u);
		em.getTransaction().commit();
	}

	public static void utilizatoriOnline(EntityManager em) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.status = ?1 ", User.class);
		query.setParameter(1, 1);
		List<User> rezultat = query.getResultList();
		for (User user : rezultat) {
			System.out.println(user.getUsername().toString());
		}
	}

	public static void produseAdaugate(EntityManager em, User u) {
		if (u.getVanzator() >= 1) {
			String idvanzator = u.getId_User().toString();
			TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.idVanzator = ?1 ", Produs.class);
			query.setParameter(1, Integer.parseInt(idvanzator));
			List<Produs> rezultat = query.getResultList();
			if (rezultat.size() == 0)
				System.out.println("Momentan nu ati adaugat niciun produs la vanzare");
			else
				for (Produs prod : rezultat) {
					System.out.println("Cod_Produs:" + prod.getCodProdus().toString() + " Denumire:"
							+ prod.getDenumire().toString() + " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
				}
		}
	}

	public static void produseDisponibile(EntityManager em) {
		TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.stoc != ?1 ", Produs.class);
		query.setParameter(1, 0);
		List<Produs> rezultat = query.getResultList();
		if (rezultat.size() == 0)
			System.out.println("Nu sunt produse disponibile!");
		else
			for (Produs prod : rezultat) {
				System.out.println("Cod_Produs:" + prod.getCodProdus().toString() + " Denumire:"
						+ prod.getDenumire().toString() + " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
			}
	}

	public static void cautareCod(EntityManager em, Integer codp) {
		String cod = codp.toString();
		try {
			Produs prod = new Produs();
			TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.codProdus = ?1 ", Produs.class);
			query.setParameter(1, cod);
			prod = (Produs) query.getSingleResult();
			System.out.println("Cod_Produs:" + prod.getCodProdus().toString() + " Denumire:"
					+ prod.getDenumire().toString() + " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
		} catch (NoResultException e) {
			System.out.println("Nu exista niciun produs cu acest cod!");
		}
	}

	public static void cautareDenumire(EntityManager em, String denumire) {
		try {
			Produs prod = new Produs();
			TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.denumire = ?1 ", Produs.class);
			query.setParameter(1, denumire);
			prod = (Produs) query.getSingleResult();
			System.out.println("Cod_Produs:" + prod.getCodProdus().toString() + " Denumire:"
					+ prod.getDenumire().toString() + " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
		} catch (NoResultException e) {
			System.out.println("Produsul " + denumire + " nu exista in magazin.");
		}
	}

	public static void veziCos(EntityManager em, User u) {
		if (u.getVanzator() >= 1) {
			String idvanzator = u.getId_User().toString();
			TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.idVanzator = ?1 ", Produs.class);
			query.setParameter(1, Integer.parseInt(idvanzator));
			List<Produs> rezultat = query.getResultList();
			if (rezultat.size() == 0)
				System.out.println("Momentan nu ati adaugat niciun produs la vanzare");
			else
				for (Produs prod : rezultat) {
					System.out.println("Cod_Produs:" + prod.getCodProdus().toString() + " Denumire:"
							+ prod.getDenumire().toString() + " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
				}
		}
	}

	public static void changePassword(EntityManager em, User u, Scanner sc) {
		System.out.println(u.getUsername().toString() + "  " + u.getPassword().toString());
		System.out.println("Introduceti noua parola:");
		String newpassword = sc.nextLine();
		em.getTransaction().begin();
		u.setPassword(newpassword);
		/*
		 * int query =
		 * em.createQuery("UPDATE User u SET u.password = ?1 "+"WHERE u.id_User = ?2")
		 * .setParameter(1, newpassword).setParameter(2,
		 * u.getId_User().toString()).executeUpdate();
		 */
		em.merge(u);
		em.getTransaction().commit();
		System.out.println(u.getUsername().toString() + "  " + u.getPassword().toString());
	}

	public static void istoricComenzi(EntityManager em, User u, Scanner sc) {
		try {
			TypedQuery<Comanda> query = em.createQuery("SELECT c FROM Comanda c WHERE c.id_User = ?1 ", Comanda.class);
			query.setParameter(1, Integer.parseInt(u.getId_User().toString()));
			List<Comanda> comenzi = query.getResultList();
			for (Comanda comanda : comenzi) {
				int idcomanda = Integer.parseInt(comanda.getComandaId().toString());
				System.out.println("Comanda " + comanda.getComandaId().toString());
				TypedQuery<DetaliiComanda> query1 = em
						.createQuery("SELECT d FROM DetaliiComanda d WHERE d.comandaId = ?1 ", DetaliiComanda.class);
				query1.setParameter(1, idcomanda);
				Integer pret = 0;
				List<DetaliiComanda> produsecomandate = query1.getResultList();
				for (DetaliiComanda detaliiComanda : produsecomandate) {
					pret = pret + detaliiComanda.getPrettotal();
					Produs prod = new Produs();
					TypedQuery<Produs> query2 = em.createQuery("SELECT p FROM Produs p WHERE p.codProdus = ?1 ",
							Produs.class);
					Integer cod = detaliiComanda.getCodProdus();
					query2.setParameter(1, cod.toString());
					prod = query2.getSingleResult();
					System.out.println(
							"Produs ID:" + detaliiComanda.getCodProdus() + " Denumire:" + prod.getDenumire().toString()
									+ " Cantitatea comandata: " + detaliiComanda.getCantitate());
				}
				System.out.println("Comanda a fost platita cu " + pret);
			}
		} catch (NoResultException e) {
			System.out.println(" Nu ai dat pana acum nicio comanda!");
		}
	}

	public static void comanda(EntityManager em, User u, Scanner sc) {
		em.getTransaction().begin();
		Comanda comanda = new Comanda();
		comanda.setId_User(Integer.parseInt(u.getId_User().toString()));
		em.persist(comanda);
		em.getTransaction().commit();
		int opt;
		do {
			DetaliiComanda detalii = new DetaliiComanda();
			System.out.println("Introduceti codul produsului:");
			Integer cod = Integer.parseInt(sc.nextLine());
			boolean bun = true;
			Produs prod = new Produs();
			while (bun) {
				try {
					TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.codProdus = ?1 ",
							Produs.class);
					query.setParameter(1, cod.toString());
					prod = (Produs) query.getSingleResult();
					bun = false;
				} catch (NoResultException e) {
					System.out.println("Acest produs nu se afla in magazin!");
					System.out.println("Introduceti codul produsului:");
					cod = Integer.parseInt(sc.nextLine());
				}
			}
			detalii.setComandaId(Integer.parseInt(comanda.getComandaId().toString()));
			detalii.setCodProdus(cod);
			detalii.setPrettotal(0);
			System.out.println("Introduceti cantitatea:");
			int cantitate = Integer.parseInt(sc.nextLine());
			Integer pret = 0;
			do {
				if (cantitate <= prod.getStoc()) {
					detalii.setCantitate(cantitate);
					detalii.setPrettotal(detalii.getPrettotal() + (cantitate * prod.getPret()));
					pret = pret + detalii.getPrettotal();
				} else {
					System.out.println("Nu avem atatea produse in stoc" + " Stocul de " + prod.getDenumire().toString()
							+ " este: " + prod.getStoc());
					System.out.println("Introduceti cantitatea:");
					cantitate = Integer.parseInt(sc.nextLine());
				}

			} while (cantitate > prod.getStoc());
			em.getTransaction().begin();
			em.persist(detalii);
			em.getTransaction().commit();
			System.out.println("1.Adaugati un alt produs in cos.\n 2.Finalizare Comanda");
			opt = Integer.parseInt(sc.nextLine());
			if (opt == 2) {
				int idcomanda = Integer.parseInt(comanda.getComandaId().toString());
				TypedQuery<DetaliiComanda> query1 = em
						.createQuery("SELECT d FROM DetaliiComanda d WHERE d.comandaId = ?1 ", DetaliiComanda.class);
				query1.setParameter(1, idcomanda);

				List<DetaliiComanda> produse = query1.getResultList();
				for (DetaliiComanda detaliiComanda : produse) {
					Produs cumparat = new Produs();
					Integer codp = detaliiComanda.getCodProdus();
					TypedQuery<Produs> query2 = em.createQuery("SELECT p FROM Produs p WHERE p.codProdus = ?1 ",
							Produs.class);

					query2.setParameter(1, codp.toString());
					cumparat = query2.getSingleResult();
					cumparat.setStoc(cumparat.getStoc() - cantitate);
					em.getTransaction().begin();
					em.merge(cumparat);
					em.getTransaction().commit();
				}
				u.setBuget(u.getBuget() - pret);
				em.getTransaction().begin();
				em.merge(u);
				em.getTransaction().commit();
			}
		} while (opt == 1);
	}

	public static void meniu(EntityManager entityManager, User u, Scanner sc) {
		int optUser;
		System.out.println(
				"------------Meniu------------\n 1.Vezi produsele disponibile\n 2.Cauta un produs dupa cod produs\n3.Cauta un produs dupa denumire\n4.Plasease o comanda\n5.Vezi istoricul cumaparaturilor");
		if (u.getVanzator() >= 1) {
			System.out.println("------------Meniu Vanzator------------");
			System.out.println("\n6.Adauga un produs la vanzare\n7.Vezi produsele adaugate");
		}
		System.out.println("\n8.Schimba parola");
		System.out.println("\n9.Deconectare");
		optUser = Integer.parseInt(sc.nextLine());
		switch (optUser) {
		case 1: {
			produseDisponibile(entityManager);
			meniu(entityManager, u, sc);
			break;
		}
		case 2: {
			System.out.println("Cod_Produs:");
			int cautare = Integer.parseInt(sc.nextLine());
			cautareCod(entityManager, cautare);
			meniu(entityManager, u, sc);
			break;
		}
		case 3: {
			System.out.println("Denumire:");
			String cautare = sc.nextLine();
			cautareDenumire(entityManager, cautare);
			meniu(entityManager, u, sc);
			break;
		}
		case 4: {
			comanda(entityManager, u, sc);
			meniu(entityManager, u, sc);
			break;
		}
		case 5: {
			istoricComenzi(entityManager, u, sc);
			meniu(entityManager, u, sc);
			break;
		}
		case 6: {
			adaugaProdus(entityManager, u);
			meniu(entityManager, u, sc);
			break;
		}
		case 7: {
			produseAdaugate(entityManager, u);
			meniu(entityManager, u, sc);
			break;
		}
		case 8: {
			changePassword(entityManager, u, sc);
			meniu(entityManager, u, sc);
			break;
		}
		case 9: {
			deconectare(entityManager, u);
			break;
		}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// EntityManager entityManager =
		// Persistence.createEntityManagerFactory("Tema_MIP_2").createEntityManager();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema_MIP_2");
		EntityManager entityManager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		int opt;
		System.out.println("Nu sunteti autentificat!\n 1.Autentificare\n 2.Register");
		opt = Integer.parseInt(sc.nextLine());
		switch (opt) {
		case 1: {
			User u = new User();
			u = login(entityManager, u, sc);
			meniu(entityManager, u, sc);
			break;
		}
		case 2: {
			register(entityManager);
			System.out.println("Te-ai inregistrat! Te rugam sa te autentifici!");
			User u = new User();
			u = login(entityManager, u, sc);
			meniu(entityManager, u, sc);
			break;
		}
		}
		entityManager.close();
	}

}
