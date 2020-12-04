package udemy_hibernate.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_pet")
public class Pet extends BaseEntity{


	
	@Basic (optional=false)
	@Column(name="pet_name") // optional. column name is "name" in default 
	private String name;
	
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	public Pet() {
		this.birthDate=birthDate;
	}  
	
	public Pet(String name, Date birthDate) {
		this.name= name;
		this.birthDate=birthDate;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [id=" + getId() + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	
	
}
