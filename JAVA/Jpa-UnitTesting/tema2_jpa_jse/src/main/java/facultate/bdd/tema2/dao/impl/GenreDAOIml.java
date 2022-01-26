package facultate.bdd.tema2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import facultate.bdd.tema2.dao.interfaces.GenreDAO;
import facultate.bdd.tema2.entities.Genre;
import facultate.bdd.tema2.util.ConnectionManager;

public class GenreDAOIml implements GenreDAO {
	ConnectionManager conManager;
	EntityManager em;

	public GenreDAOIml(String persistenceUnitName) {
		conManager = new ConnectionManager(persistenceUnitName);
	}

	@Override
	public void close() {
		conManager.close();

	}

	@Override
	public Genre createOrUpdate(Genre entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.persist(entity);
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
	public Genre findById(int id) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.find(Genre.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public Genre update(Genre entity) {
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
	public void delete(Genre entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			em.getTransaction().begin();
			entity = em.find(Genre.class, entity.getId());
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
			for (Genre g : readAll()) {
				delete(g);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<Genre> readAll() {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.createQuery("from Genre", Genre.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
