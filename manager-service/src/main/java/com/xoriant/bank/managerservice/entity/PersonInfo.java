package com.xoriant.bank.managerservice.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

enum Gender {
	MALE, FEMALE
};

@Entity
public class PersonInfo {

	@Id
	@GeneratedValue
	private int personId;

	private String name;
	private LocalDate dob;

	@Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String emailId;
	private String mobileNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonInfo [personId=" + personId + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}

	public PersonInfo() {

	}
	
	

}
