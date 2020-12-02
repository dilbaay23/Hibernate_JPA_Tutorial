package udemy_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_vet")
public class Vet extends Person {

	@Column(name="works_full_time")
	private boolean isWorksFullTime;

	public boolean isWorksFullTime() {
		return isWorksFullTime;
	}

	public void setWorksFullTime(boolean isWorksFullTime) {
		this.isWorksFullTime = isWorksFullTime;
	}
	
	
}
