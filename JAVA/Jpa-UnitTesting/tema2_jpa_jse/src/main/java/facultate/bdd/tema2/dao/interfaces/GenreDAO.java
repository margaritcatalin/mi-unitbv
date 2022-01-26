package facultate.bdd.tema2.dao.interfaces;

import java.util.List;

import facultate.bdd.tema2.entities.Genre;

/** TODO: Implement this interface **/
public interface GenreDAO extends GenericDAO<Genre> {
	public void close();

	public Genre createOrUpdate(Genre entity);

	public Genre findById(int id);

	public Genre update(Genre entity);

	public void delete(Genre entity);

	public void deleteAll();

	public List<Genre> readAll();
}
