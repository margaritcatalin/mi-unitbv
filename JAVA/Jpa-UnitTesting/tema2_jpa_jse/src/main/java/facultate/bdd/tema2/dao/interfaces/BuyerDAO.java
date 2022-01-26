package facultate.bdd.tema2.dao.interfaces;

import java.util.List;

import facultate.bdd.tema2.entities.Buyer;

/** TODO: Implement this interface **/
public interface BuyerDAO extends GenericDAO<Buyer> {
	public void close();

	public Buyer createOrUpdate(Buyer entity);

	public Buyer findById(int id);

	public Buyer update(Buyer entity);

	public void delete(Buyer entity);

	public void deleteAll();

	public List<Buyer> readAll();
}
