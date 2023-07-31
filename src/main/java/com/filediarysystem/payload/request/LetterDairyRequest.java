package com.filediarysystem.payload.request;

import com.filediarysystem.entities.ContactDetails;
import com.filediarysystem.entities.LetterDiary;

public class LetterDairyRequest 
{
	private LetterDiary letterDiary;
	private ContactDetails contactDetails;
	
	public LetterDairyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LetterDairyRequest(LetterDiary letterDiary, ContactDetails contactDetails) {
		super();
		this.letterDiary = letterDiary;
		this.contactDetails = contactDetails;
	}
	public LetterDiary getLetterDiary() {
		return letterDiary;
	}
	public void setLetterDiary(LetterDiary letterDiary) {
		this.letterDiary = letterDiary;
	}
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	@Override
	public String toString() {
		return "LetterDairyRequest [letterDiary=" + letterDiary + ", contactDetails=" + contactDetails + "]";
	}
}
