package com.filediarysystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class BlockUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String url;
	private String userrole;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BlockUrl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlockUrl(Long id, String url, String userrole, String status) {
		super();
		this.id = id;
		this.url = url;
		this.userrole = userrole;
		this.status = status;
	}
	@Override
	public String toString() {
		return "BlockUrl [id=" + id + ", url=" + url + ", userrole=" + userrole + ", status=" + status + "]";
	}
}
