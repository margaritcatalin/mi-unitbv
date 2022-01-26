package facultate.bdd.tema2.dao.interfaces;

import java.util.List;

import facultate.bdd.tema2.entities.OrderEntry;

/** TODO: Implement this interface **/
public interface OrderEntryDAO extends GenericDAO<OrderEntry> {
	public void close();

	public OrderEntry createOrUpdate(OrderEntry entity);

	public OrderEntry findById(int id);

	public OrderEntry update(OrderEntry entity);

	public void delete(OrderEntry entity);

	public void deleteAll();

	public List<OrderEntry> readAll();
}
