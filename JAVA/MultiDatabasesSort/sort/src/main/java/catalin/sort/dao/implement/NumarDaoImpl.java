package catalin.sort.dao.implement;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import catalin.sort.dao.interfaces.INumarDAO;
import catalin.sort.entities.Numar;
import catalin.sort.util.HibernateUtil;

public class NumarDaoImpl implements INumarDAO {
	Configuration configuration1;
	Configuration configuration2;
	SessionFactory factory1;
	SessionFactory factory2;

	public NumarDaoImpl(String persistenceUnitName1, String persistenceUnitName2) {
		configuration1 = new Configuration();
		configuration2 = new Configuration();
		configuration1.configure(persistenceUnitName1);
		configuration2.configure(persistenceUnitName2);
		factory1 = configuration1.buildSessionFactory();
		factory2 = configuration2.buildSessionFactory();

	}

	@Override
	public void findAllNumar() {
		// TODO Auto-generated method stub
		ArrayList<Numar> numberList = new ArrayList<Numar>();
		Session sessionDB1 = factory1.openSession();
		Session sessionDB2 = factory2.openSession();
		try {
			Transaction transaction = sessionDB1.beginTransaction();
			if (!transaction.isActive())
				transaction.begin();
			Criteria crit = sessionDB1.createCriteria(Numar.class);
			numberList = (ArrayList) crit.list();
			System.out.println("Records from first Database");
			System.out.println();
			for (Numar nr : numberList) {
				System.out.print(nr.getNumar() + " ");

			}
			Criteria crit1 = sessionDB2.createCriteria(Numar.class);
			numberList = (ArrayList) crit1.list();
			System.out.println("Records from last Database");
			for (Numar nr : numberList) {
				System.out.print(nr.getNumar() + " ");

			}
		} catch (Exception he) {
			he.printStackTrace();
		} finally {
			sessionDB1.close();
			sessionDB2.close();
		}
	}

	@Override
	public void insertBb1Numar(Numar nr) {
		// TODO Auto-generated method stub
		Session sessionDB1 = factory1.openSession();
		try {
			Transaction transaction = sessionDB1.beginTransaction();
			if (!transaction.isActive())
				transaction.begin();
			sessionDB1.save(nr);
			sessionDB1.flush();
			transaction.commit();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
			sessionDB1.close();
		}
	}

	@Override
	public void insertBb2Numar(Numar nr) {
		// TODO Auto-generated method stub
		Session sessionDB2 = factory2.openSession();
		try {
			Transaction transaction = sessionDB2.beginTransaction();
			if (!transaction.isActive())
				transaction.begin();
			sessionDB2.save(nr);
			sessionDB2.flush();
			transaction.commit();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
			sessionDB2.close();
		}
	}

	@Override
	public void close() {
		factory1.close();
		factory2.close();
	}
}
