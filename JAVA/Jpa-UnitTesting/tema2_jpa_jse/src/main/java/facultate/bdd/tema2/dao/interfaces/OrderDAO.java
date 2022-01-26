package facultate.bdd.tema2.dao.interfaces;

import java.util.List;

import facultate.bdd.tema2.entities.Order;

/** TODO: Implement this interface **/
public interface OrderDAO extends GenericDAO<Order> {
	public void close();

	public Order createOrUpdate(Order entity);

	public Order findById(int id);

	public Order update(Order entity);

	public void delete(Order entity);

	public void deleteAll();

	public List<Order> readAll();
}
