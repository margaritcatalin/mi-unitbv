package facultate.bdd.tema2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import facultate.bdd.tema2.dao.interfaces.OrderDAO;
import facultate.bdd.tema2.entities.Order;
import facultate.bdd.tema2.util.ConnectionManager;

public class OrderDAOIml implements OrderDAO {
	ConnectionManager conManager;
	EntityManager em;

	public OrderDAOIml(String persistenceUnitName) {
		conManager = new ConnectionManager(persistenceUnitName);
	}

	@Override
	public void close() {
		conManager.close();

	}

	@Override
	public Order createOrUpdate(Order entity) {
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
	public Order findById(int id) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.find(Order.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Order update(Order entity) {
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
	public void delete(Order entity) {
		try {
			em = conManager.getEMFactory().createEntityManager();
			em.getTransaction().begin();
			entity = em.find(Order.class, entity.getId());
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
			for (Order o : readAll()) {
				delete(o);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Order> readAll() {
		try {
			em = conManager.getEMFactory().createEntityManager();
			return em.createQuery("from Order", Order.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
