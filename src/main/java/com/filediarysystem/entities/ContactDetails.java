package com.filediarysystem.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String designation;
	private String organisation;
	private String mobileno;
	private String email;
	private String address;
	private String country;
	private String state;
	private String city;
	private Long pincode;
	private String landline;
	private String fax;
	private Long user_id;
	private Date cdt;
	private String status;
	private Long sessionid;
	private Long letter_diary_id;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Date getCdt() {
		return cdt;
	}
	public void setCdt(Date cdt) {
		this.cdt = cdt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getSessionid() {
		return sessionid;
	}
	public void setSessionid(Long sessionid) {
		this.sessionid = sessionid;
	}
	
	public Long getLetter_diary_id() {
		return letter_diary_id;
	}
	public void setLetter_diary_id(Long letter_diary_id) {
		this.letter_diary_id = letter_diary_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public ContactDetails() {}
	public ContactDetails(Long id, String name, String designation, String organisation, String mobileno, String email,
			String address, String country, String state, String city, Long pincode, String landline, String fax,
			Long user_id, Date cdt, String status, Long sessionid, Long letter_diary_id) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.organisation = organisation;
		this.mobileno = mobileno;
		this.email = email;
		this.address = address;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.landline = landline;
		this.fax = fax;
		this.user_id = user_id;
		this.cdt = cdt;
		this.status = status;
		this.sessionid = sessionid;
		this.letter_diary_id = letter_diary_id;
	}
	@Override
	public String toString() {
		return "ContactDetails [id=" + id + ", name=" + name + ", designation=" + designation + ", organisation="
				+ organisation + ", mobileno=" + mobileno + ", email=" + email + ", address=" + address + ", country="
				+ country + ", state=" + state + ", city=" + city + ", pincode=" + pincode + ", landline=" + landline
				+ ", fax=" + fax + ", user_id=" + user_id + ", cdt=" + cdt + ", status=" + status + ", sessionid="
				+ sessionid + ", letter_diary_id=" + letter_diary_id + "]";
	}
}
