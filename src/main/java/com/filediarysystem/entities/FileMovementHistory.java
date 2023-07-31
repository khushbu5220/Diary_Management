package com.filediarysystem.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FileMovementHistory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate send_date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate received_date;
	private String remarks;
	private String send_to_division;
	private Long file_id;
	private Long user_id;
	private String status;
	private Date cdt;
	private Long session_id;
	public FileMovementHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileMovementHistory(Long id, LocalDate send_date, LocalDate received_date, String remarks,
			String send_to_division, Long file_id, Long user_id, String status, Date cdt, Long session_id) {
		super();
		this.id = id;
		this.send_date = send_date;
		this.received_date = received_date;
		this.remarks = remarks;
		this.send_to_division = send_to_division;
		this.file_id = file_id;
		this.user_id = user_id;
		this.status = status;
		this.cdt = cdt;
		this.session_id = session_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getSend_date() {
		return send_date;
	}
	public void setSend_date(LocalDate send_date) {
		this.send_date = send_date;
	}
	public LocalDate getReceived_date() {
		return received_date;
	}
	public void setReceived_date(LocalDate received_date) {
		this.received_date = received_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getFile_id() {
		return file_id;
	}
	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCdt() {
		return cdt;
	}
	public void setCdt(Date cdt) {
		this.cdt = cdt;
	}
	public Long getSession_id() {
		return session_id;
	}
	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}
	public String getSend_to_division() {
		return send_to_division;
	}
	public void setSend_to_division(String send_to_division) {
		this.send_to_division = send_to_division;
	}
	@Override
	public String toString() {
		return "FileMovementHistory [id=" + id + ", send_date=" + send_date + ", received_date=" + received_date
				+ ", remarks=" + remarks + ", send_to_division=" + send_to_division + ", file_id=" + file_id
				+ ", user_id=" + user_id + ", status=" + status + ", cdt=" + cdt + ", session_id=" + session_id + "]";
	}
}
