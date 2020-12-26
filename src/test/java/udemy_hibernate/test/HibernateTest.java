package udemy_hibernate.test;




import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.junit.Test;

import udemy_hibernate.config.HibernateConfig;
import udemy_hibernate.config.JpaConfig;
import udemy_hibernate.entity.Address;
import udemy_hibernate.entity.Owner;
import udemy_hibernate.entity.OwnerWithCompositePK;
import udemy_hibernate.entity.OwnerWithCompositePK.OwnerId;
import udemy_hibernate.entity.Pet;
import udemy_hibernate.entity.PetType;
import udemy_hibernate.entity.Rating;
import udemy_hibernate.entity.Visit;

public class HibernateTest {
	
	@Test
	public void testQueriesWithDTO() {
		
		/*
		 * 
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		
		String queryString = "select new udemy_hibernate.entity.Pet(p.name, p.birthDate) from Pet p";   
		

		List<Pet> resultList = session.createQuery(queryString).getResultList(); 
		
		resultList.forEach(System.out::println);
		
		*/
		
		
		 // other alternative for create a Dto object
		
		 
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		
		String queryString = "select p.name as name,  p.birthDate as birthDate from Pet p";   
		

		List<Pet> resultList = session.createQuery(queryString).setResultTransformer(new AliasToBeanResultTransformer(Pet.class)).getResultList();
		
		resultList.forEach(System.out::println);
		 
					
	}
	
	
	
	@Test
	public void testRaporQueries() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		
		String queryString = "select p.name, p.birthDate from Pet p";   
		

		
		List<Object[]> resultList = session.createQuery(queryString).getResultList();   
		
		for(Object[] row : resultList) {   
			
			String name=(String) row[0];
			Date birthDate = (Date)row[1];
			System.out.printf("Pet with name: %s and birth date : %s \n", name,birthDate);
			
		}
				
	}
	
	
	
	@Test
	public void testOwnerJoins() {
	
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		
		String queryString = "select distinct o from Owner o inner join o.pets p where p.name like :petName";   
		
		Query<Owner> query = session.createQuery(queryString);
		
		query.setParameter("petName", "%");
		
		List<Owner> resultList = query.getResultList();   //it returns an Object array List because of join. first element of Object[] owner and second element is Pet. 
		
		resultList.forEach(System.out::println);
		
	}
		
		
		
		
	
		
	
	@Test
	public void testJoins() {
	
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		
		String queryString = "from Owner o inner join o.pets p where p.name like :petName";   // we dont have to use "select from" . it is an optional using
		
		Query query = session.createQuery(queryString);
		
		query.setParameter("petName", "K%");
		
		List<Object[]> resultList = query.getResultList();   //it returns an Object array List because of join. first element of Object[] owner and second element is Pet. 
		
		for(Object[] row : resultList) {   
			
			Owner o = (Owner) row[0];
			Pet p= (Pet)row[1];
			System.out.println("Owner : " + o);
			System.out.println("Pet : " + p);
			
		}
		
	
	}
	
	
	
	@Test
	public void testHql() {
	
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		String queryString="select p from Pet p where p.name like :petName or p.petType.id = :typeId";
		
		//String queryString="select p from Pet p where p.name like ?1 or p.petType.id =?2";    //positional Parameters. it is not recommended practice. named Parameters using is better than positional parameters
		
		Query<Pet> query= session.createQuery(queryString);
		
		
		//named Paremeters
		query.setParameter("petName", "A%");
		query.setParameter("typeId", 1L);
		
		/*
		 // for positional Parameters use keys. 
		query.setParameter(1, "M%");
		query.setParameter(2, 1L);
		*/
	
		
		
		
		List<Pet> resultList = query.getResultList();
		
		System.out.println("----query executed----");
		resultList.forEach(System.out::println);
		
		}
	
	
	@Test
	public void testAuditInterceptor() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		Pet pet = new Pet("mars2",new Date());

		
		session.persist(pet);
		
		
		Pet pet2= session.get(Pet.class,1000L);
		
		pet2.setBirthDate(null);
		
		session.delete(session.load(Pet.class, 2000L));
		
		
		tx.commit();
		session.close();
	
	}
	
	@Test
	public void testDelete() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		Visit visit = session.get(Visit.class, 1L);
		session.delete(visit);   // you can delete the objects both in session and detached in hibernate directly with delete method without doing extra things
		
		tx.commit();
		session.close();
	
	}
	
	
	@Test
	public void testDetachedEntitiesAndLazy() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		Pet pet = session.get(Pet.class, 1L);
	
	
		
		//session.close();
		//session.clear();
		session.evict(pet);  // session is still open but the pet entity is not in persistence context anymore
		
		System.out.println(".......after session evict....");
		
		System.out.println("Session open: " + session.isOpen());
		
		session.update(pet);
		//session.saveOrUpdate(pet); it uses update method at the back
		
		System.out.println(String.format("Pets name size: %s", (pet.getName()).length()));
		System.out.printf("Pets name size: %d %tA%n", (pet.getName()).length(),new Date());
		
		tx.commit();
		session.close();
	
	}
	
	@Test
	public void testDetachedEntities() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		Pet pet = session.get(Pet.class, 1L);
		
		session.close();
		pet.setBirthDate(new Date());
		
	
		tx.commit();
			
	}
	
	
	@Test
	public void testUpdate() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		Pet pet = session.get(Pet.class, 1L);
		pet.setBirthDate(new Date());
		
		pet.setPetType((PetType) session.load(PetType.class,1L));
		System.out.println(pet.getBirthDate());
		
		
		tx.commit();
		session.close();
	
	}

	
	@Test
	public void testLoad() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		Pet pet = session.load(Pet.class, 1L);
		System.out.println(".....Pet Loading.......");
		if (pet==null) {
			System.out.println("pet is null returning");
			
		}
		System.out.println(pet.getName());
		System.out.println(pet.getClass());
			
	
	}
	
	@Test
	public void testGet() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		Pet pet = session.get(Pet.class, 1L);
		System.out.println(".....Pet Loading.......");
		if (pet==null) {
			System.out.println("pet is null returning");
			
		}
		System.out.println(pet.getName());
		System.out.println(pet.getClass());
			
	
	}
	
	@Test
	public void testHibernateSetup() {
		Session session = (Session) HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close(); // we should always close session. a session is for only a user and it must not take long time that a session waits as open, to get updated info
		HibernateConfig.getSessionFactory().close(); // this is for testing. normally we do this before terminate the application.
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
		owner.setRating(Rating.PREMIUM);
		
		Address address = new Address();
		address.setStreet("Azale");
		address.setPhone("0232541222");
		
		owner.setAdress(address);

	
		session.persist(owner);
		
		tx.commit();
		session.close(); 
	    	
	}
	
	
	
	

}

