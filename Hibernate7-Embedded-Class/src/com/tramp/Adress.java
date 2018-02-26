package com.tramp;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
	public String locality;
	public String zipCode;
	public String street;
	public int streetNr;

	public Adress() {
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNr() {
		return streetNr;
	}

	public void setStreetNr(int streetNr) {
		this.streetNr = streetNr;
	}
}