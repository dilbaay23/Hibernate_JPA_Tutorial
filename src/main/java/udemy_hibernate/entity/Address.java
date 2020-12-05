package udemy_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * if we manage this embeddable classes state in secondary table, then we should use the same @Column(table="t_adress") annotation with the same table name for all fields. 
 */
@Embeddable
public class Address {
	
	@Column(table="t_address", name="phone_type")
	@Enumerated(EnumType.STRING)
	private PhoneType PhoneType;
	
	@Column(table="t_address")
	private String street;
	
	@Column(table="t_address")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="city_id", table="t_address", foreignKey=@ForeignKey(name="fk_address_city"))  // we can give a name for Foreign key as seen.
	private City city;
	
	public String getStreet() {
		return street;
	} 
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
