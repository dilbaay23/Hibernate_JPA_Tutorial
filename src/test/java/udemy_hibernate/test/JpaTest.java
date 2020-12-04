package udemy_hibernate.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import udemy_hibernate.config.JpaConfig;
import udemy_hibernate.entity.Address;
import udemy_hibernate.entity.Owner;
import udemy_hibernate.entity.Pet;
import udemy_hibernate.entity.Rating;

public class JpaTest {

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
