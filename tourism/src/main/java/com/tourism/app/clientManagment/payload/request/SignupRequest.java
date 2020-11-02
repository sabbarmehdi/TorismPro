package com.tourism.app.clientManagment.payload.request;


import com.sun.istack.NotNull;
import com.tourism.app.clientManagment.model.Car;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;


public class SignupRequest {

	//@NotBlank
	@Size(min = 3, max = 50)
	private String username;

	//@NotBlank
	@Size(min = 1, max = 50)
	private String firstName;

	//@NotBlank
	@Size(min = 1, max = 50)
	private String lastName;

	//@NotBlank
	@Size(max = 100)
	@Email
	private String email;

	private Set<String> role;


	//@NotBlank
	@Size(min = 6, max = 100)
	private static String password;


	private String cin;

	private String license;

	private Car car;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		SignupRequest.password = password;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}