package udemy_hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	static {
		Configuration cfg = new Configuration().configure();  // loads the hibernate confiurations
		sessionFactory=cfg.buildSessionFactory();
	}

}
