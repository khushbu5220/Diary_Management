package com.filediarysystem.payload.response;

public class FileMovementHistoryReportResponse 
{
	private String send_date;
	private String received_date;
	private String remarks;
	private String send_to_division;
	private String cdt;
	public FileMovementHistoryReportResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileMovementHistoryReportResponse(String send_date, String received_date, String remarks,
			String send_to_division, String cdt) {
		super();
		this.send_date = send_date;
		this.received_date = received_date;
		this.remarks = remarks;
		this.send_to_division = send_to_division;
		this.cdt = cdt;
	}
	public String getSend_date() {
		return send_date;
	}
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	public String getReceived_date() {
		return received_date;
	}
	public void setReceived_date(String received_date) {
		this.received_date = received_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSend_to_division() {
		return send_to_division;
	}
	public void setSend_to_division(String send_to_division) {
		this.send_to_division = send_to_division;
	}
	public String getCdt() {
		return cdt;
	}
	public void setCdt(String cdt) {
		this.cdt = cdt;
	}
	@Override
	public String toString() {
		return "FileMovementHistoryReportResponse [send_date=" + send_date + ", received_date=" + received_date
				+ ", remarks=" + remarks + ", send_to_division=" + send_to_division + ", cdt=" + cdt + "]";
	}
}
