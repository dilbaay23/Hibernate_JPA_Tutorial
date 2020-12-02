package udemy_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@SecondaryTable(name = "t_adress", pkJoinColumns = @PrimaryKeyJoinColumn(name="owner_id"))
@Entity
@Table(name="t_owner")
public class Owner extends Person {
	
	@Embedded   //In fact if we use @Embeddable on the Address class, we shouldn't use here @Embedded
	private Address adress;

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	

}
