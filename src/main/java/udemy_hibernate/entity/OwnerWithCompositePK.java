package udemy_hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.marshalling.SerializabilityChecker;

@Entity
@Table(name="t_owner_with_composite_pk")
public class OwnerWithCompositePK {
	
	/*we should put @Embeddable annotation on the Composite PK classes
	 * and this classes should implement Serializable Interface
	 * We create here an inner static class but it could be a normal class too.
	 */
	
	@Embeddable 
	public static class OwnerId implements Serializable{
		@Column(name="firstname", nullable=false)
		private String firstName;
		
		@Column(name="lastname", nullable=false)
		private String lastName;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
	}
	
	// we have a PK with more than one column
	@Id
	private OwnerId id;
	
	//@Column
	private String ownerCity;

	public OwnerId getId() {
		return id;
	}

	public void setId(OwnerId id) {
		this.id = id;
	}

	public String getOwnerCity() {
		return ownerCity;
	}

	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}
	
	

}
