package com.catalin.connections;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.catalin.models.*;

public class DataAccessLayer {
	EntityManagerFactory factory = null;
	EntityManager em = null;

	public DataAccessLayer() {
		factory = Persistence.createEntityManagerFactory("Examen");
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
		u.setTip(0);
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

	public Postare cautareTitlu(String denumire) {
		try {
			Postare post = new Postare();
			TypedQuery<Postare> query = em.createQuery("SELECT p FROM Postare p WHERE p.titlu = ?1 ", Postare.class);
			query.setParameter(1, denumire);
			post = (Postare) query.getSingleResult();
			return post;
		} catch (NoResultException e) {
			System.out.println("Postarea cu titlul" + denumire + " nu exista.");
			return null;
		}
	}

	public void bloguriPostate(User u) {
		TypedQuery<Postare> query = em.createQuery("SELECT p FROM Postare p inner join p.user u WHERE p.user = ?1 ",
				Postare.class);
		query.setParameter(1, u);
		List<Postare> rezultat = query.getResultList();
		if (rezultat.size() == 0)
			System.out.println("Momentan nu ati postat nimic!");
		else
			for (Postare post : rezultat) {
				System.out.println(post.toString());
			}
	}

	public void postariExistente() {
		TypedQuery<Postare> query = em.createQuery("SELECT p FROM Postare p", Postare.class);
		List<Postare> rezultat = query.getResultList();
		if (rezultat.size() == 0)
			System.out.println("Nu sunt postari pe blog!");
		else
			for (Postare post : rezultat) {
				System.out.println(post.toString());
			}
	}

	public void comentariiPost() {
		postariExistente();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduceti Id postarii:");
		int cautare = Integer.parseInt(sc.nextLine());
		Postare post = new Postare();
		try {
			TypedQuery<Postare> query = em.createQuery("SELECT p FROM Postare p WHERE p.idPostare = ?1 ",
					Postare.class);
			query.setParameter(1, cautare);
			post = (Postare) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Postarea cu id" + cautare + " nu exista.");
		}
		if (post != null) {
			TypedQuery<Comentariu> query1 = em
					.createQuery("SELECT c FROM Comentariu c WHERE c.postare= ?1 AND c.accept>0", Comentariu.class);
			query1.setParameter(1, post);
			List<Comentariu> rezultat = query1.getResultList();
			if (rezultat.size() == 0)
				System.out.println("Nu sunt comentarii la acest post!");
			else
				for (Comentariu coms : rezultat) {
					System.out.println(coms.toString());
				}
		}
	}

	public void adaugaPostare(User l) {
		em.getTransaction().begin();
		Postare pos = new Postare();
		Scanner sc = new Scanner(System.in);
		System.out.println("------------Postare------------");
		System.out.println("Titlu:");
		pos.setTitlu(sc.nextLine());
		System.out.println("Textul postarii:");
		pos.setPostare(sc.nextLine());
		pos.setUser(l);
		em.persist(pos);
		em.getTransaction().commit();
	}

	public void adaugaComentariu(User l, Scanner sc) {
		postariExistente();
		System.out.print("Introdu id postului:");
		int cautare = Integer.parseInt(sc.nextLine());
		Postare pos = new Postare();
		try {
			TypedQuery<Postare> query = em.createQuery("SELECT p FROM Postare p WHERE p.idPostare = ?1", Postare.class);
			query.setParameter(1, cautare);
			pos = (Postare) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Aceasta postare nu exista!");
		}
		if (pos != null) {
			System.out.println("Introduceti textul comentariului:");
			Comentariu com = new Comentariu();
			com.setComentariu(sc.nextLine());
			com.setAccept(0);
			com.setUser(l);
			com.setPostare(pos);
			em.getTransaction().begin();
			em.persist(com);
			em.getTransaction().commit();
			System.out.println("Comentariu adaugat cu succes!");
		}
	}

	public void acceptaComentariu(User l, Scanner sc) {
		postariExistente();
		System.out.print("Introdu id postului:");
		int cautare = Integer.parseInt(sc.nextLine());
		Postare pos = new Postare();
		try {
			TypedQuery<Postare> query = em.createQuery("SELECT p FROM Postare p WHERE p.idPostare = ?1 AND p.user= ?2",
					Postare.class);
			query.setParameter(1, cautare);
			query.setParameter(2, l);
			pos = (Postare) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Aceasta postare nu exista sau nu este adaugat de dumneavoastra!");
		}
		if (pos != null) {
			TypedQuery<Comentariu> query1 = em
					.createQuery("SELECT c FROM Comentariu c WHERE c.postare = ?1 AND c.accept!= 1 ", Comentariu.class);
			query1.setParameter(1, pos);
			List<Comentariu> rezultat = query1.getResultList();
			if (rezultat.size() > 0) {
				for (Comentariu com : rezultat) {
					System.out.println(com.toString());
				}
				System.out.println("Introdu id comentariului:");
				cautare = Integer.parseInt(sc.nextLine());
				Comentariu coms = new Comentariu();
				try {
					TypedQuery<Comentariu> query = em.createQuery(
							"SELECT c FROM Comentariu c WHERE c.idComentariu= ?1 AND c.postare= ?2", Comentariu.class);
					query.setParameter(2, pos);
					query.setParameter(1, cautare);
					coms = (Comentariu) query.getSingleResult();
				} catch (NoResultException e) {
					System.out.println("Aceasta postare nu exista sau nu este adaugat de dumneavoastra!");
				}
				if (coms != null) {
					System.out.println("Introduceti 1.Pentru a accpeta comentariul\n2.Pnetru a sterge comentariul");
					int opt = Integer.parseInt(sc.nextLine());
					switch (opt) {
					case 1: {
						em.getTransaction().begin();
						coms.setAccept(1);
						em.persist(coms);
						em.getTransaction().commit();
						break;
					}
					case 2: {
						em.getTransaction().begin();
						em.remove(coms);
						em.getTransaction().commit();
						break;
					}
					}
				}
			}
		}
	}

	public void removePost(User l, Scanner sc) {
		System.out.print("---------------Sterge un post-------------");
		bloguriPostate(l);
		System.out.print("Introdu id postului:");
		int cautare = Integer.parseInt(sc.nextLine());
		Postare pos = new Postare();
		try {
			TypedQuery<Postare> query = em.createQuery("SELECT p FROM Postare p WHERE p.idPostare = ?1 AND p.user= ?2",
					Postare.class);
			query.setParameter(1, cautare);
			query.setParameter(2, l);
			pos = (Postare) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Aceasta postare nu exista sau nu este postata de dumneavoastra!");
		}
		if (pos != null) {
			Comentariu card = new Comentariu();
			TypedQuery<Comentariu> query1 = em.createQuery("SELECT c FROM Comentariu c WHERE c.postare = ?1 ",
					Comentariu.class);
			query1.setParameter(1, pos);
			List<Comentariu> rezultat = query1.getResultList();
			if (rezultat.size() > 0)
				for (Comentariu com : rezultat) {
					em.getTransaction().begin();
					em.remove(com);
					em.getTransaction().commit();
					pos.removeComentarius(com);
				}
			em.getTransaction().begin();
			em.remove(pos);
			em.getTransaction().commit();
		}
	}
}
