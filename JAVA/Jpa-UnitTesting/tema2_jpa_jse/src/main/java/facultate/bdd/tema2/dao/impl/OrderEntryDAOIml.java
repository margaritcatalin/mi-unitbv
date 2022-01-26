package facultate.bdd.tema2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import facultate.bdd.tema2.dao.interfaces.OrderEntryDAO;
import facultate.bdd.tema2.entities.OrderEntry;
import facultate.bdd.tema2.util.ConnectionManager;

public class OrderEntryDAOIml implements OrderEntryDAO {
	ConnectionManager conManager;
	EntityManager em;

	public OrderEntryDAOIml(String persistenceUnitName) {
		conManager = new ConnectionManager(persistenceUnitName);
	}

	@Override
	public void close() {
		conManager.close();

	}

	@Override
	public OrderEntry createOrUpdate(OrderEntry entity) {
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
	public OrderEntry findById(int id) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.find(OrderEntry.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public OrderEntry update(OrderEntry entity) {
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
	public void delete(OrderEntry entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			em.getTransaction().begin();
			entity = em.find(OrderEntry.class, entity.getId());
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
			for (OrderEntry oe : readAll()) {
				delete(oe);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<OrderEntry> readAll() {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.createQuery("from OrderEntry", OrderEntry.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
