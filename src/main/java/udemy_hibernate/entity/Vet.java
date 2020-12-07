package udemy_hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@DiscriminatorValue("V")
@Entity
@Table(name="t_vet")
public class Vet extends Person {

	@Column(name="works_full_time")
	private boolean isWorksFullTime;
	
    @ManyToMany
    @JoinTable(name="t_vet_specialty", joinColumns = @JoinColumn(name="vet_id"), inverseJoinColumns= @JoinColumn( name="specialty_id" ))
	private Set<Specialty> specialties = new HashSet<>();

	public boolean isWorksFullTime() {
		return isWorksFullTime;
	}

	public void setWorksFullTime(boolean isWorksFullTime) {
		this.isWorksFullTime = isWorksFullTime;
	}
	
	
}
