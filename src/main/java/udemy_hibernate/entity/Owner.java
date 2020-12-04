package udemy_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


@TypeDef(name="ratingType", typeClass = RatingUserType.class)              // this is for UserType implementation class. we write over class and it is Global annotation. then we can use this over methods if we need
@SecondaryTable(name = "t_adress", pkJoinColumns = @PrimaryKeyJoinColumn(name="owner_id"))
@Entity
@Table(name="t_owner")
public class Owner extends Person {
	
	@Type(type="ratingType")							// this annotation is for Hibernate and JPA for Custom converter class which implements UserType interface
	//@Convert(converter=RatingAttributeConverter.class) 	// we should use this annotation explicitly for Hibernate if we implement only AttributeConverter Interface. 
													
	//@Enumerated(EnumType.ORDINAL)   					 //if we have RatingAttributeConverter implementation class, we don't we don't need to use both @Convert and @Enumarated in JPA anymore , it will be persist and be read with its converted values
	private Rating rating;
	
	@Embedded   //In fact if we use @Embeddable on the Address class, we shouldn't use here @Embedded
	private Address adress;

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {   
		this.adress = adress;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	
	

}
