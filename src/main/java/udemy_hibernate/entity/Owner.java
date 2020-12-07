package udemy_hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@DiscriminatorValue("O")
@TypeDef(name="ratingType", typeClass = RatingUserType.class)              // this is for UserType implementation class. we write over class and it is Global annotation. then we can use this over methods if we need
@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name="owner_id"))
@Entity
@Table(name="t_owner")
public class Owner extends Person {
	
	@Type(type="ratingType")							// this annotation is for Hibernate and JPA for Custom converter class which implements UserType interface
	//@Convert(converter=RatingAttributeConverter.class) 	// we should use this annotation explicitly for Hibernate if we implement only AttributeConverter Interface. 
													
	//@Enumerated(EnumType.ORDINAL)   					 //if we have RatingAttributeConverter implementation class, we don't we don't need to use both @Convert and @Enumarated in JPA anymore , it will be persist and be read with its converted values
	private Rating rating;
	
	
	/*
	 * As a default Hibernate create a table for associations between two table for @OneToMany annotation. 
	 * but if don't want this creation of table we can change this manage by using @JoinColumn annotation. after it , Hibernate will create a column in Pet table with name of "owner_id" . 
	 */
	//@OneToMany                
	//@JoinColumn(name="owner_id")
	//private Set<Pet> pets = new HashSet<>();
	
	
	/*
	 * if we use bidirectional tables, (i used @ManyToOne in Pet class with owner instance by  Owner Type. So there is a bidirectional Associations between this two classes)
	 * As a default Hibernate looks to all info for all changes and creations in two classes . it performs too much. In fact it is enough if it looks to only one .
	 * We use mappedBy attribute with @OneToMany. and we give instance name. not class or Type
	 */
	
	@OneToMany (mappedBy="owner")   // this owner is not the name of the class. it is the instance name which has been created in Pet class by Owner Type. This field has became read only association.To create or drop a pet in this list is only can be doen in Petclass.this filed is only for read           
	private Set<Pet> pets = new HashSet<>();
	
	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

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
