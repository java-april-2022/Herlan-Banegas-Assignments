package com.week4.saveTravels.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 200, message = "Name cannot be blank")
	private String name;

	@NotNull
	@Size(min = 1, max = 200, message = "Vendor cannot be blank")
	private String vendor;

	@NotNull(message = "Amount cannot be blank")
	@Min(value = 0, message = "Amount must be greater than zero")
	private Double ammount;

	@NotNull
	@Size(min = 1, max = 200, message = "Description cannot be blank")
	private String description;

	public Expense() {
	}

	public Expense(String name, String vendor, Double amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.ammount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
