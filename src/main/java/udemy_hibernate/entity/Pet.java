package udemy_hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
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
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@OneToMany
	@JoinColumn(name="pet_id")
	@OrderColumn(name = "visit_order")
	private List<Visit> visits = new ArrayList<>();
	
	
	
	public Pet() {
		
	}  
	
	public Pet(String name, Date birthDate) {
		this.name= name;
		this.birthDate=birthDate;
	}



	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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
