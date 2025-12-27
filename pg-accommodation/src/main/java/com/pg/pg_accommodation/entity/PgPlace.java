package com.pg.pg_accommodation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pg_places")
public class PgPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String pgName;
	@NotBlank
	private String registrationNumber;
	private double builtUpArea;
	private double rentAmount;
	@NotBlank
	private String city;
	@NotBlank
	private String locality;
	
	@Enumerated(EnumType.STRING)
	private AvailabilityStatus status;
	
	private int visitorCount=0;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	
	public String getPgName() {
		return pgName;
	}
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public double getBuiltUpArea() {
		return builtUpArea;
	}
	public void setBuiltUpArea(double builtUpArea) {
		this.builtUpArea = builtUpArea;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public AvailabilityStatus getStatus() {
		return status;
	}
	public void setStatus(AvailabilityStatus status) {
		this.status = status;
	}
	public int getVisitorCount() {
		return visitorCount;
	}
	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
