package facultate.bdd.tema2.util;

import facultate.bdd.tema2.dao.impl.*;
import facultate.bdd.tema2.dao.interfaces.BookDAO;
import facultate.bdd.tema2.dao.interfaces.BuyerDAO;
import facultate.bdd.tema2.dao.interfaces.GenreDAO;
import facultate.bdd.tema2.dao.interfaces.OrderDAO;
import facultate.bdd.tema2.dao.interfaces.OrderEntryDAO;

public class EntityDAOImplFactory {

	public static BookDAO createNewBookDAOImpl(String persistenceUnitName) {
		/** TODO: return a new instance of your BookDAO implementation **/
		return new BookDAOIml(persistenceUnitName);
	}

	public static BuyerDAO createNewBuyerDAOImpl(String persistenceUnitName) {
		/** TODO: return a new instance of your BuyerDAO implementation **/
		return new BuyerDAOIml(persistenceUnitName);
	}

	public static GenreDAO createNewGenreDAOImpl(String persistenceUnitName) {
		/** TODO: return a new instance of your GenreDAO implementation **/
		return new GenreDAOIml(persistenceUnitName);
	}

	public static OrderDAO createNewOrderDAOImpl(String persistenceUnitName) {
		/** TODO: return a new instance of your OrderDAO implementation **/
		return new OrderDAOIml(persistenceUnitName);
	}

	public static OrderEntryDAO createNewOrderEntryDAOImpl(String persistenceUnitName) {
		/** TODO: return a new instance of your OrderEntryDAO implementation **/
		return new OrderEntryDAOIml(persistenceUnitName);
	}
}
