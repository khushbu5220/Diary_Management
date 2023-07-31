package com.filediarysystem.payload.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchFileDiaryRequest 
{
	private String file_no;
	private String reference_no;
	private String received_from;
	private String subject;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate from_date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate to_date;
	public SearchFileDiaryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchFileDiaryRequest(String file_no, String reference_no, String received_from, String subject,
			LocalDate from_date, LocalDate to_date) {
		super();
		this.file_no = file_no;
		this.reference_no = reference_no;
		this.received_from = received_from;
		this.subject = subject;
		this.from_date = from_date;
		this.to_date = to_date;
	}
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getReference_no() {
		return reference_no;
	}
	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}
	public String getReceived_from() {
		return received_from;
	}
	public void setReceived_from(String received_from) {
		this.received_from = received_from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDate getFrom_date() {
		return from_date;
	}
	public void setFrom_date(LocalDate from_date) {
		this.from_date = from_date;
	}
	public LocalDate getTo_date() {
		return to_date;
	}
	public void setTo_date(LocalDate to_date) {
		this.to_date = to_date;
	}
	@Override
	public String toString() {
		return "SearchFileDiaryRequest [file_no=" + file_no + ", reference_no=" + reference_no + ", received_from="
				+ received_from + ", subject=" + subject + ", from_date=" + from_date + ", to_date=" + to_date + "]";
	}
}
