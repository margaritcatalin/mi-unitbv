package facultate.bdd.tema2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import facultate.bdd.tema2.dao.interfaces.BuyerDAO;
import facultate.bdd.tema2.entities.Buyer;
import facultate.bdd.tema2.util.ConnectionManager;

public class BuyerDAOIml implements BuyerDAO {
	ConnectionManager conManager;
	EntityManager em;

	public BuyerDAOIml(String persistenceUnitName) {
		conManager = new ConnectionManager(persistenceUnitName);
	}

	@Override
	public void close() {
		conManager.close();

	}

	@Override
	public Buyer createOrUpdate(Buyer entity) {
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
	public Buyer findById(int id) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.find(Buyer.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Buyer update(Buyer entity) {
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
	public void delete(Buyer entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			em.getTransaction().begin();
			entity = em.find(Buyer.class, entity.getId());
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
			for (Buyer b : readAll()) {
				delete(b);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Buyer> readAll() {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.createQuery("from Buyer", Buyer.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
