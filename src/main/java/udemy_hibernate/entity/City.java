package udemy_hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_city")
public class City extends BaseEntity{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
