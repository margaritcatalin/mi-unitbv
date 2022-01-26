package facultate.bdd.tema2.dao.interfaces;

import java.util.List;

import facultate.bdd.tema2.entities.Book;

/** TODO: Implement this interface **/
public interface BookDAO extends GenericDAO<Book> {
	public void close();

	public Book createOrUpdate(Book entity);

	public Book findById(int id);

	public Book update(Book entity);

	public void delete(Book entity);

	public void deleteAll();

	public List<Book> readAll();
}
