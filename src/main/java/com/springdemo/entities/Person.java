package com.springdemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="person")
public class Person {
	
	@Id
	@SequenceGenerator(
			name = "person_sequence",
			sequenceName = "person_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "person_sequence"
			
	)
	@Column(
			name= "id",
			updatable = false
			)
	private int id;
	@Column(
			name= "nic",
			nullable = false
			)
	private String nic;
	@Column(
			name= "first_name",
			nullable = false,
			columnDefinition = "TEXT"
			)
	private String firstName;
	@Column(
			name= "first_name",
			nullable = false,
			columnDefinition = "TEXT"
			)
	private String lastName;
	private int mobileNumber;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
}
