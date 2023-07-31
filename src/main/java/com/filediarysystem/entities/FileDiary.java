package com.filediarysystem.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FileDiary 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String file_no;
	private String received_from;
	private String reference_no;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate file_date;
	private String subject;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate received_date;
	private String send_to_designation;
	private String send_to_division;
	private Long user_id;
	private Date cdt;
	private String remarks;
	private String status;
	private Long session_id;
	public FileDiary() {}
	public FileDiary(Long id, String file_no, String received_from, String reference_no, LocalDate file_date,
			String subject, LocalDate received_date, String send_to_designation, String send_to_division, Long user_id,
			Date cdt, String remarks, String status, Long session_id) {
		super();
		this.id = id;
		this.file_no = file_no;
		this.received_from = received_from;
		this.reference_no = reference_no;
		this.file_date = file_date;
		this.subject = subject;
		this.received_date = received_date;
		this.send_to_designation = send_to_designation;
		this.send_to_division = send_to_division;
		this.user_id = user_id;
		this.cdt = cdt;
		this.remarks = remarks;
		this.status = status;
		this.session_id = session_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getReceived_from() {
		return received_from;
	}
	public void setReceived_from(String received_from) {
		this.received_from = received_from;
	}
	public String getReference_no() {
		return reference_no;
	}
	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}
	public LocalDate getFile_date() {
		return file_date;
	}
	public void setFile_date(LocalDate file_date) {
		this.file_date = file_date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDate getReceived_date() {
		return received_date;
	}
	public void setReceived_date(LocalDate received_date) {
		this.received_date = received_date;
	}
	public String getSend_to_designation() {
		return send_to_designation;
	}
	public void setSend_to_designation(String send_to_designation) {
		this.send_to_designation = send_to_designation;
	}
	public String getSend_to_division() {
		return send_to_division;
	}
	public void setSend_to_division(String send_to_division) {
		this.send_to_division = send_to_division;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Date getCdt() {
		return cdt;
	}
	public void setCdt(Date cdt) {
		this.cdt = cdt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getSession_id() {
		return session_id;
	}
	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}
	@Override
	public String toString() {
		return "FileDiary [id=" + id + ", file_no=" + file_no + ", received_from=" + received_from + ", reference_no="
				+ reference_no + ", file_date=" + file_date + ", subject=" + subject + ", received_date="
				+ received_date + ", send_to_designation=" + send_to_designation + ", send_to_division="
				+ send_to_division + ", user_id=" + user_id + ", cdt=" + cdt + ", remarks=" + remarks + ", status="
				+ status + ", session_id=" + session_id + "]";
	}
}
