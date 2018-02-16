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

import model.Comanda;
import model.Detaliicomanda;
import model.Produs;
import model.User;

public class DataAccesLayer {
	EntityManagerFactory factory = null;
	EntityManager em = null;

	public DataAccesLayer() {
		factory = Persistence.createEntityManagerFactory("MIP2");
		em = factory.createEntityManager();
	}

	public void register() {
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
		u.setTip(0);
		u.setBuget(50000);
		em.persist(u);
		em.getTransaction().commit();
	}

	public User login(User l, Scanner sc) {
		boolean deconectat = true;
		while (deconectat) {
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
				deconectat = false;
			} catch (NoResultException e) {
				System.out.println("Nu ati introdus datele cum trebuie sau acest cont nu exista!");
			}
		}
		return l;
	}

	public void deconectare() {
		System.out.println("V-ati deconectat cu succes.\nLa revedere!");
		em.close();
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

	public void adaugaProdus(User l) {
		if (l.getTip() >= 1) {
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
			produs.setUser(l);
			em.persist(produs);
			em.getTransaction().commit();
		}
	}

	public void produseAdaugate(User u) {
		if (u.getTip() >= 1) {
			TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p JOIN p.user u WHERE p.user = ?1 ",
					Produs.class);
			query.setParameter(1, u);
			List<Produs> rezultat = query.getResultList();
			if (rezultat.size() == 0)
				System.out.println("Momentan nu ati adaugat niciun produs la vanzare");
			else
				for (Produs prod : rezultat) {
					System.out.println("Cod_Produs:" + prod.getIdProdus() + " Denumire:" + prod.getDenumire().toString()
							+ " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
				}
		}
	}

	public void istoricComenzi(User u, Scanner sc) {
		List<Comanda> comenzi = new ArrayList<>();
		try {
			TypedQuery<Comanda> query = em.createQuery("SELECT c FROM Comanda c WHERE c.user = ?1 ", Comanda.class);
			query.setParameter(1, u);
			comenzi = query.getResultList();
			for (Comanda comanda : comenzi) {
				System.out.println("Comanda " + comanda.getIdComanda());
				TypedQuery<Produs> query1 = em.createQuery("SELECT p FROM Produs p JOIN p.detaliicomandas d WHERE d.comanda = ?1 ", Produs.class);
				query1.setParameter(1, comanda);
				List<Produs> produsecomandate = query1.getResultList();
				for (Produs detaliiComanda : produsecomandate) {
					System.out.println(
							"Produs ID:" + detaliiComanda.getIdProdus() + " Denumire:" + detaliiComanda.getDenumire());
				}
				System.out.println("Comanda a fost platita cu " + comanda.getPretTotal());
			}
		} catch (NoResultException e) {
			System.out.println(" Nu ai dat pana acum nicio comanda!");
		}
	}

	public void comanda(User u, Scanner sc) {
		em.getTransaction().begin();
		Comanda comanda = new Comanda();
		comanda.setUser(u);
		comanda.setPretTotal(0);
		int pret=0;
		em.persist(comanda);
		em.getTransaction().commit();
		int opt;
		do {
			Detaliicomanda detalii = new Detaliicomanda();
			System.out.println("Introduceti codul produsului:");
			Integer cod = Integer.parseInt(sc.nextLine());
			boolean gasit = false;
			Produs prod = new Produs();
			while (!gasit) {
				try {
					TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.idProdus = ?1 ",
							Produs.class);
					query.setParameter(1, cod);
					prod = (Produs) query.getSingleResult();
					gasit = true;
				} catch (NoResultException e) {
					System.out.println("Acest produs nu se afla in magazin!");
					System.out.println("Introduceti codul produsului:");
					cod = Integer.parseInt(sc.nextLine());
				}
			}
			detalii.setComanda(comanda);
			detalii.setProdus(prod);
			System.out.println("Introduceti cantitatea:");
			int cantitate = Integer.parseInt(sc.nextLine());
			do {
				if (cantitate <= prod.getStoc()) {
					detalii.setCantitate(cantitate);
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
			pret=pret+cantitate*prod.getPret();
			comanda.setPretTotal(pret);
			if (null != em) {
				EntityTransaction updateTransaction = em.getTransaction();
				updateTransaction.begin();
				Query query = em.createQuery("UPDATE Comanda c SET c.pretTotal =c.pretTotal+ ?1 " + "WHERE c.idComanda = ?2");
				query.setParameter(1, cantitate * prod.getPret());
				query.setParameter(2,comanda.getIdComanda());
				int updateCount = query.executeUpdate();
				updateTransaction.commit();
			}
			System.out.println("1.Adaugati un alt produs in cos.\n 2.Finalizare Comanda");
			opt = Integer.parseInt(sc.nextLine());
			if (opt > 2||opt<1) {
				System.out.println("Adaugati o optiune valida\n1.Adaugati un alt produs in cos.\n 2.Finalizare Comanda");
				opt = Integer.parseInt(sc.nextLine());
			}
			if (opt == 2) {
				TypedQuery<Detaliicomanda> query1 = em
						.createQuery("SELECT d FROM Detaliicomanda d WHERE d.comanda = ?1 ", Detaliicomanda.class);
				query1.setParameter(1, comanda);

				List<Detaliicomanda> produse = query1.getResultList();
				for (Detaliicomanda detaliiComanda : produse) {
					if (null != em) {
						EntityTransaction updateTransaction = em.getTransaction();
						updateTransaction.begin();
						Query query = em.createQuery("UPDATE Produs p SET p.stoc = ?1 " + "WHERE p.idProdus = ?2");
						query.setParameter(1, detaliiComanda.getProdus().getStoc() - detaliiComanda.getCantitate());
						query.setParameter(2, detaliiComanda.getProdus().getIdProdus());
						int updateCount = query.executeUpdate();
						updateTransaction.commit();
					}
				}
				if (null != em) {
					EntityTransaction updateTransaction = em.getTransaction();
					updateTransaction.begin();
					Query query = em.createQuery("UPDATE User u SET u.buget = ?1 " + "WHERE u.idUser = ?2");
					query.setParameter(1, (comanda.getUser().getBuget() - comanda.getPretTotal()));
					query.setParameter(2, comanda.getUser().getIdUser());
					int updateCount = query.executeUpdate();
					updateTransaction.commit();
				}
				System.out.println("Comanda dumneavoastra a fost trimisa!");
			}
		} while (opt == 1);
	}

	public void cautareDenumire(String denumire) {
		try {
			Produs prod = new Produs();
			TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.denumire = ?1 ", Produs.class);
			query.setParameter(1, denumire);
			prod = (Produs) query.getSingleResult();
			System.out.println("Cod_Produs:" + prod.getIdProdus() + " Denumire:" + prod.getDenumire().toString()
					+ " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
		} catch (NoResultException e) {
			System.out.println("Produsul " + denumire + " nu exista in magazin.");
		}
	}

	public void cautareCod(Integer codp) {
		try {
			Produs prod = new Produs();
			TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.idProdus = ?1 ", Produs.class);
			query.setParameter(1, codp);
			prod = (Produs) query.getSingleResult();
			System.out.println("Cod_Produs:" + prod.getIdProdus() + " Denumire:" + prod.getDenumire().toString()
					+ " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
		} catch (NoResultException e) {
			System.out.println("Nu exista niciun produs cu acest cod!");
		}
	}

	public void produseDisponibile() {
		TypedQuery<Produs> query = em.createQuery("SELECT p FROM Produs p WHERE p.stoc != ?1 ", Produs.class);
		query.setParameter(1, 0);
		List<Produs> rezultat = query.getResultList();
		if (rezultat.size() == 0)
			System.out.println("Nu sunt produse disponibile!");
		else
			for (Produs prod : rezultat) {
				System.out.println("Cod_Produs:" + prod.getIdProdus() + " Denumire:" + prod.getDenumire().toString()
						+ " Pret:" + prod.getPret() + " Stoc:" + prod.getStoc());
			}
	}

}
