 package com.filediarysystem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User 
{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)     
		private Long userid;
     	private String displayname;
	    @Column(unique = true)
		private String username;
		private String emailId;
		private String password;
		private String ustatus;
		private String role;
		private Date cdt;
		private String division;
		private String designation;
		public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCdt() {
		return cdt;
	}
	public void setCdt(Date cdt) {
		this.cdt = cdt;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public User(Long userid, String displayname, String username, String emailId, String password, String ustatus,
			String role, Date cdt, String division, String designation) {
		super();
		this.userid = userid;
		this.displayname = displayname;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.ustatus = ustatus;
		this.role = role;
		this.cdt = cdt;
		this.division = division;
		this.designation = designation;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", displayname=" + displayname + ", username=" + username + ", emailId="
				+ emailId + ", password=" + password + ", ustatus=" + ustatus + ", role=" + role + ", cdt=" + cdt
				+ ", division=" + division + ", designation=" + designation + "]";
	}	
}
