package udemy_hibernate.test;




import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import udemy_hibernate.config.HibernateConfig;
import udemy_hibernate.config.JpaConfig;
import udemy_hibernate.entity.Address;
import udemy_hibernate.entity.Owner;
import udemy_hibernate.entity.OwnerWithCompositePK;
import udemy_hibernate.entity.OwnerWithCompositePK.OwnerId;
import udemy_hibernate.entity.Pet;

public class HibernateTest {
	@Test
	public void testHibernateSetup() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close(); // we should always close session. a session is for only a user and it must not take long time that a session waits as open, to get updated info
		//HibernateConfig.getSessionFactory().close(); // this is for testing. normally we do this before terminate the application.
	}
	
	@Test
	public void testCreateEntity() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Pet pet = new Pet();
		//pet.setId(1l);
		pet.setName("Mars");
		
		
		session.persist(pet);
		
		tx.commit();
		session.close(); // we should always close session. a session is for only a user and it must not take long time that a session waits as open, to get updated info
		//HibernateConfig.getSessionFactory().close(); // this is for testing. normally we do this before terminate the application.
	}
	
	@Test
	public void testFieldLevelAccess() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Pet pet = new Pet("Pitir",new Date());
		//pet.setId(1L);
		
		session.persist(pet);
		
		tx.commit();
		session.close(); 
		
	    session = (Session) HibernateConfig.getSessionFactory().openSession();
	    
	    Pet pet2= session.get(Pet.class,1L);
	    System.out.println(pet2);
  	
	}
	
	
	@Test
	public void testWithoutTransaction() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		
		Pet pet = new Pet("Pitir",new Date());
		//pet.setId(1L);
		
		session.persist(pet);
		
		/*
		 * in jpa we cant persist our data without trancasction.
		 * but with Native Hibernate we can do this wit a configuration in hibernate.properties
		 * hibernate.allow_update_outside_transaction=true
		 */
		session.flush();     // this method is for  synchronize context and persistence. 
		
	
		session.close(); // we should always close entityManager. a entityManager is for only a user and it must not take long time that a entityManager waits as open , to get updated info
	
	}
	
	
	
	/*
	 * Hibernate doesnt control nullability before insert operations. so we can see this statements on console. but it cant persist it because name should be set
	 * with a properties we can do hibernate to control nullability before insert operations. 
	 *  hibernate.check_nullability=true
	 *  after this properties we take again exception but it is other than before and insert statement will not work. 
	 */
	
	@Test
	public void tetsCheckNullability() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Pet pet = new Pet();
		//pet.setId(1L);
		
		session.persist(pet);
		
		tx.commit();
		session.close(); 
	
	}
	@Test
	public void testCompositPK() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		OwnerWithCompositePK owner = new OwnerWithCompositePK();
		OwnerId oId= new OwnerId();
		oId.setFirstName("Baha");
		oId.setLastName("Koc");
		
		owner.setId(oId);
		owner.setOwnerCity("Maas");
		
		session.persist(owner);
		
		tx.commit();
		session.close(); 
	    	
	}
	
	
	@Test
	public void testEmbeddable() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Owner owner = new Owner();
		owner.setFirstName("Elif");
		owner.setLastName("Koc");
		
		Address address = new Address();
		address.setStreet("Azale");
		address.setPhone("0232541222");
		
		owner.setAdress(address);

	
		session.persist(owner);
		
		tx.commit();
		session.close(); 
	    	
	}
	
	

}

