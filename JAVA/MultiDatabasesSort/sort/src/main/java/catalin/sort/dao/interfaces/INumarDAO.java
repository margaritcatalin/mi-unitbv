package catalin.sort.dao.interfaces;

import catalin.sort.entities.Numar;

public interface INumarDAO {
	public void findAllNumar();

	public void insertBb1Numar(Numar nr);
	public void insertBb2Numar(Numar nr);
	public void close();
}
