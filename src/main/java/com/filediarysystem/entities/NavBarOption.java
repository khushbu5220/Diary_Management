package com.filediarysystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NavBarOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String headername;
	private Long headerpredessor;
	private String headerurl;
	private String foruserrole;
	private String status;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getHeadername() {
		return headername;
	}
	public void setHeadername(String headername) {
		this.headername = headername;
	}
	public Long getHeaderpredessor() {
		return headerpredessor;
	}
	public void setHeaderpredessor(Long headerpredessor) {
		this.headerpredessor = headerpredessor;
	}
	public String getHeaderurl() {
		return headerurl;
	}
	public void setHeaderurl(String headerurl) {
		this.headerurl = headerurl;
	}
	public String getForuserrole() {
		return foruserrole;
	}
	public void setForuserrole(String foruserrole) {
		this.foruserrole = foruserrole;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public NavBarOption() {
	}
	public NavBarOption(Long id, String headername, Long headerpredessor, String headerurl, String foruserrole,
			String status) {
		Id = id;
		this.headername = headername;
		this.headerpredessor = headerpredessor;
		this.headerurl = headerurl;
		this.foruserrole = foruserrole;
		this.status = status;
	}
	@Override
	public String toString() {
		return "NavBarOption [Id=" + Id + ", headername=" + headername + ", headerpredessor=" + headerpredessor
				+ ", headerurl=" + headerurl + ", foruserrole=" + foruserrole + ", status=" + status + "]";
	}
	
}
