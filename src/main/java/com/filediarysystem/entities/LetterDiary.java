package com.filediarysystem.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class LetterDiary {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String letter_number;
	private String received_from;
	private String refrence_no;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate letter_date;
	private String subject;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate received_date;
	private Date cdt;
	private String send_to_designation;
	private String send_to_division;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate diary_date;
	private String form_of_communication;
	private String language;
	private Long user_id;
	private String remarks;
	private String vip;
	private String status;
	private Long session_id;
	public LetterDiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LetterDiary(Long id, String letter_number, String received_from, String refrence_no, LocalDate letter_date,
			String subject, LocalDate received_date, Date cdt, String send_to_designation, String send_to_division,
			LocalDate diary_date, String form_of_communication, String language, Long user_id, String remarks,
			String vip, String status, Long session_id) {
		super();
		this.id = id;
		this.letter_number = letter_number;
		this.received_from = received_from;
		this.refrence_no = refrence_no;
		this.letter_date = letter_date;
		this.subject = subject;
		this.received_date = received_date;
		this.cdt = cdt;
		this.send_to_designation = send_to_designation;
		this.send_to_division = send_to_division;
		this.diary_date = diary_date;
		this.form_of_communication = form_of_communication;
		this.language = language;
		this.user_id = user_id;
		this.remarks = remarks;
		this.vip = vip;
		this.status = status;
		this.session_id = session_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLetter_number() {
		return letter_number;
	}
	public void setLetter_number(String letter_number) {
		this.letter_number = letter_number;
	}
	public String getReceived_from() {
		return received_from;
	}
	public void setReceived_from(String received_from) {
		this.received_from = received_from;
	}
	public String getRefrence_no() {
		return refrence_no;
	}
	public void setRefrence_no(String refrence_no) {
		this.refrence_no = refrence_no;
	}
	public LocalDate getLetter_date() {
		return letter_date;
	}
	public void setLetter_date(LocalDate letter_date) {
		this.letter_date = letter_date;
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
	public Date getCdt() {
		return cdt;
	}
	public void setCdt(Date cdt) {
		this.cdt = cdt;
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
	public LocalDate getDiary_date() {
		return diary_date;
	}
	public void setDiary_date(LocalDate diary_date) {
		this.diary_date = diary_date;
	}
	public String getForm_of_communication() {
		return form_of_communication;
	}
	public void setForm_of_communication(String form_of_communication) {
		this.form_of_communication = form_of_communication;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
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
		return "LetterDiary [id=" + id + ", letter_number=" + letter_number + ", received_from=" + received_from
				+ ", refrence_no=" + refrence_no + ", letter_date=" + letter_date + ", subject=" + subject
				+ ", received_date=" + received_date + ", cdt=" + cdt + ", send_to_designation=" + send_to_designation
				+ ", send_to_division=" + send_to_division + ", diary_date=" + diary_date + ", form_of_communication="
				+ form_of_communication + ", language=" + language + ", user_id=" + user_id + ", remarks=" + remarks
				+ ", vip=" + vip + ", status=" + status + ", session_id=" + session_id + "]";
	}
}
