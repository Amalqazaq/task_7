package com.example.accessinglocation;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 
	 private int id;
	 private String streetAddress;
	 private String postalCode;
	 private String stateProvince;
	 private String City;
	 private int countryId;
	 //private Country country;
	 
	 

	public int getId() {
		return id;
	}
	public void setId(int loc_id) {
		this.id = loc_id;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String street_address) {
		this.streetAddress = street_address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postal_code) {
		this.postalCode = postal_code;
	}
	public String getStateProvince() {

		return stateProvince;
	}
	public void setStateProvince(String state_province) {
		this.stateProvince = state_province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryid) {
		this.countryId = countryid;
	}
	/*public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}*/
}
