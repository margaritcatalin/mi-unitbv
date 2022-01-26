package catalin.sort.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory buildSessionFactory(String configFile){
        try {
            return new Configuration().configure(configFile).buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession(String configFile){
       SessionFactory sf = buildSessionFactory(configFile);
       return sf.openSession();
    }
}
