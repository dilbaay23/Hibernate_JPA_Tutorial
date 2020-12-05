package udemy_hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_clinic")
public class Clinic extends BaseEntity {
	
	private String name;
	
	
	/*
	 * As a default Hibernate create a table for associations between two table for @OneToMany annotation. 
	 * We can manage association table  and give personal columns names  by using @JoinTable
	 */
	@OneToMany
	@JoinTable(name="t_clinic_owner", joinColumns = @JoinColumn(name="clinic_id"), inverseJoinColumns = @JoinColumn(name="owner_id"))
	private Set<Owner> owners = new HashSet<>();
	
	@OneToMany
	@JoinTable(name="t_clinic_vet", joinColumns = @JoinColumn(name="clinic_id"), inverseJoinColumns = @JoinColumn(name="vet_id"))
	private Set<Vet> vets = new HashSet<>();
	
	

	public Set<Owner> getOwners() {
		return owners;
	}

	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}

	public Set<Vet> getVets() {
		return vets;
	}

	public void setVets(Set<Vet> vets) {
		this.vets = vets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
