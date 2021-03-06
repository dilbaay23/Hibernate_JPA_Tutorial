package udemy_hibernate.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.stat.Statistics;
import org.junit.Test;

import udemy_hibernate.config.HibernateConfig;
import udemy_hibernate.config.JpaConfig;
import udemy_hibernate.entity.Address;
import udemy_hibernate.entity.Owner;
import udemy_hibernate.entity.Pet;
import udemy_hibernate.entity.Rating;
import udemy_hibernate.entity.Visit;

public class JpaTest {
	
	
	@Test
	public void testJpql() {
	
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		
		//String queryString="select p from Pet p where p.name like :petName or p.petType.id = :typeId";
		
		String queryString="select p from Pet p where p.name like ?1 or p.petType.id =?2";    //positional Parameters. it is not best practice. Use-keys of named Parameters is better than positional parameters
		
		
		TypedQuery<Pet> typedQuery= entityManager.createQuery(queryString,Pet.class);
		
		/*
		//named Paremeters
		typedQuery.setParameter("petName", "K%");
		typedQuery.setParameter("typeId", 2L);
		*/
		
		 // for positional Parameters use keys. 
		typedQuery.setParameter(1, "S%");
		typedQuery.setParameter(2, 5L);
		
		
		List<Pet> resultList = typedQuery.getResultList();
		
		System.out.println("----query executed----");
		resultList.forEach(System.out::println);
		
		}
	
	@Test
	public void testLifeCycleCallbacks() {
		
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx= entityManager.getTransaction();
		tx.begin();
		
		Pet pet = new Pet("mars2",new Date());
		
		entityManager.persist(pet);

		
		Pet pet2= entityManager.find(Pet.class,2L);
		
		pet2.setBirthDate(null);
		
		entityManager.remove(entityManager.getReference(Pet.class, 4L));
		
		tx.commit();
		entityManager.close();
		
		
	}
	
	@Test
	public void testDelete() {
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx= entityManager.getTransaction();
		tx.begin();
		
		Visit visit = entityManager.find(Visit.class,1L);
		entityManager.remove(visit);
		
		/*                       //  in JPA  if the entity is detached then you should first merge the object and assign to a new object(it must be reattached) to do something with this object
		entityManager.clear();
		
		Visit visit1= entityManager.merge(visit);
		entityManager.remove(visit1);
		*/
		
		tx.commit();
		entityManager.close();
		
		
	}
	
	
	@Test
	public void testHibernateApiAccess() {
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx= entityManager.getTransaction();
		tx.begin();
		
		SessionFactory sf = (SessionFactory)JpaConfig.getEntityManagerFactory();  //we can access hibernate methods and objects by casting. 
		Session session= (Session) entityManager;
		Transaction hibernateTx = (Transaction) tx;
		
		Statistics statistics = sf.getStatistics();
		session.setHibernateFlushMode(FlushMode.MANUAL);
		
		
	}
	

	@Test
	public void testJpaSetup() {
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx= entityManager.getTransaction();
		tx.begin();
		tx.commit();
		entityManager.close(); // we should always close entityManager. a entityManager is for only a user and it must not take long time that a entityManager waits as open , to get updated info
		JpaConfig.getEntityManagerFactory().close();
	}
	
	
	// this method will not persist the data because thre is no transaction
	@Test
	public void testWithoutTransaction() {
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		
		Pet pet = new Pet("Pitir2",new Date());
		pet.setId(2L);
		
		entityManager.persist(pet);
		
		//entityManager.flush(); // this method is for  synchronize context and persistence. but it will throw an exception because it needs a transaction begin. and wif we commit transaction we dont need flush anymore because flush works in commit.
	
	
		entityManager.close(); // we should always close entityManager. a entityManager is for only a user and it must not take long time that a entityManager waits as open , to get updated info
	
	}
	
	@Test
	public void testRating() {
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx= entityManager.getTransaction();
		tx.begin();
		
		Owner owner = new Owner();
		owner.setFirstName("Elif Azra");
		owner.setLastName("Koc");
		owner.setRating(Rating.PREMIUM);
		
		Address address = new Address();
		address.setStreet("Azale");
		address.setPhone("0232541222");
		
		owner.setAdress(address);

		entityManager.persist(owner);
		
		
		tx.commit();
		entityManager.close();
		
	}
}
