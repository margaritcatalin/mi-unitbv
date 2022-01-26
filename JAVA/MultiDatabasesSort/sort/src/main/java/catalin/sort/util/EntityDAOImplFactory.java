package catalin.sort.util;

import catalin.sort.dao.implement.NumarDaoImpl;
import catalin.sort.dao.interfaces.INumarDAO;

public class EntityDAOImplFactory {

	public static INumarDAO createNewNumarDAOImpl(String persistanceUnitName1, String persistanceUnitName2) {
		return new NumarDaoImpl(persistanceUnitName1,persistanceUnitName2);
	}
}
