package facultate.bdd.tema2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import facultate.bdd.tema2.dao.interfaces.BookDAO;
import facultate.bdd.tema2.entities.Book;
import facultate.bdd.tema2.util.ConnectionManager;

public class BookDAOIml implements BookDAO {
	ConnectionManager conManager;
	EntityManager em;

	public BookDAOIml(String persistenceUnitName) {
		conManager = new ConnectionManager(persistenceUnitName);
	}

	@Override
	public void close() {
		conManager.close();

	}

	@Override
	public Book createOrUpdate(Book entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.merge(entity);
				em.getTransaction().commit();
			} catch (Exception ex) {
				em.getTransaction().rollback();
				em.getTransaction().begin();
				entity = em.merge(entity);
				em.getTransaction().commit();
			}
			return entity;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Book findById(int id) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.find(Book.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Book update(Book entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Book entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			em.getTransaction().begin();

			entity = em.find(Book.class, entity.getId());
			em.remove(entity);

			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void deleteAll() {
		try {
			for (Book book : readAll()) {
				delete(book);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Book> readAll() {
		try {
			em = conManager.getEMFactory().createEntityManager();

			return em.createQuery("from Book", Book.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
