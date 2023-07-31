package com.filediarysystem.payload.response;

import java.util.List;

import com.filediarysystem.entities.ContactDetails;
import com.filediarysystem.entities.LetterDiary;
import com.filediarysystem.entities.LetterMovementHistory;

public class LetterDiaryResponse 
{
	private LetterDiary letterdiary;
	private ContactDetails contactdetails;
	private List<LetterMovementHistory> lettermovementhistory;
	public LetterDiaryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LetterDiaryResponse(LetterDiary letterdiary, ContactDetails contactdetails,
			List<LetterMovementHistory> lettermovementhistory) {
		super();
		this.letterdiary = letterdiary;
		this.contactdetails = contactdetails;
		this.lettermovementhistory = lettermovementhistory;
	}
	public LetterDiary getLetterdiary() {
		return letterdiary;
	}
	public void setLetterdiary(LetterDiary letterdiary) {
		this.letterdiary = letterdiary;
	}
	public List<LetterMovementHistory> getLettermovementhistory() {
		return lettermovementhistory;
	}
	public void setLettermovementhistory(List<LetterMovementHistory> lettermovementhistory) {
		this.lettermovementhistory = lettermovementhistory;
	}
	public ContactDetails getContactdetails() {
		return contactdetails;
	}
	public void setContactdetails(ContactDetails contactdetails) {
		this.contactdetails = contactdetails;
	}
	@Override
	public String toString() {
		return "LetterDiaryResponse [letterdiary=" + letterdiary + ", contactdetails=" + contactdetails
				+ ", lettermovementhistory=" + lettermovementhistory + "]";
	}
}
