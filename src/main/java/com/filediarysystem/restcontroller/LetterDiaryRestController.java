package com.filediarysystem.restcontroller;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.filediarysystem.config.JwtAuthenticationFilter;
import com.filediarysystem.entities.ContactDetails;
import com.filediarysystem.entities.FileDiary;
import com.filediarysystem.entities.FileMovementHistory;
import com.filediarysystem.entities.LetterDiary;
import com.filediarysystem.entities.LetterMovementHistory;
import com.filediarysystem.entities.User;
import com.filediarysystem.payload.request.LetterDairyRequest;
import com.filediarysystem.payload.request.SearchLetterDiaryRequest;
import com.filediarysystem.payload.response.FileDiaryResponse;
import com.filediarysystem.payload.response.LetterDiaryResponse;
import com.filediarysystem.repositories.ContactDetailsRepository;
import com.filediarysystem.repositories.LetterDiaryRepository;
import com.filediarysystem.repositories.LetterMovementHistoryRepository;
import com.filediarysystem.repositories.UserRepository;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class LetterDiaryRestController 
{
	@Autowired
	LetterDiaryRepository letterdiaryrepository;
	@Autowired
	ContactDetailsRepository contactdetailsrepository;
	@Autowired
	JwtAuthenticationFilter JwtAuthentication;
	@Autowired
	UserRepository userrepository;
	@Autowired
	LetterMovementHistoryRepository lettermovementhistoryrepository;
	
	@PostMapping("/saveletterdiary")
	public String saveLetterDiary(@RequestBody LetterDairyRequest letterdiaryrequest) {
		String ret = "";
		ResponseEntity<?> res = null;
		try 
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			LetterDiary letterDiary = letterdiaryrequest.getLetterDiary();
			if ("".equalsIgnoreCase(letterDiary.getLetter_number())) {
				res = ResponseEntity.status(400).body("Letter No. is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getReceived_from())) {
				res = ResponseEntity.status(400).body("Received from is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}

			if ("".equalsIgnoreCase(letterDiary.getRefrence_no())) {
				res = ResponseEntity.status(400).body("Reference No. is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if (letterDiary.getLetter_date() == null) {
				res = ResponseEntity.status(400).body("Letter Date is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getSubject())) {
				res = ResponseEntity.status(400).body("Received_from is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}

			if (letterDiary.getReceived_date() == null) {
				res = ResponseEntity.status(400).body("Subject is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if("".equalsIgnoreCase(letterDiary.getSend_to_designation()))
			{
				res = ResponseEntity.status(400).body("Send to designation is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			if("".equalsIgnoreCase(letterDiary.getSend_to_division()))
			{
				res = ResponseEntity.status(400).body("Send to division is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			if (letterDiary.getDiary_date() == null) {
				res = ResponseEntity.status(400).body("Diary Date is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getForm_of_communication())) {
				res = ResponseEntity.status(400).body("Received_from is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getLanguage())) {
				res = ResponseEntity.status(400).body("Language is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getRemarks())) {
				res = ResponseEntity.status(400).body("Remarks is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getVip())) {
				res = ResponseEntity.status(400).body("VIP status is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			letterDiary.setCdt(new Date());
			letterDiary.setUser_id(user.getUserid());
			letterDiary.setStatus("active");			
			letterDiary.setSession_id(null);
			LetterDiary letterdiary = letterdiaryrepository.save(letterDiary);
						
			ContactDetails contactDetails = letterdiaryrequest.getContactDetails();
			contactDetails.setCdt(new Date());
			contactDetails.setStatus("active");
			contactDetails.setSessionid(null);
			contactDetails.setLetter_diary_id(letterdiary.getId());
			contactDetails.setUser_id(user.getUserid());
			contactdetailsrepository.save(contactDetails);
			
			res = ResponseEntity.status(201).body("Letter diary entry saved successfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
		}
		catch(Exception e)
		{
			res = ResponseEntity.status(400).body("Letter diary entry saved unsuccessfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			e.printStackTrace();
		}
		return ret;
	}
	
	@PutMapping("/editletterdiary/{Id}")
	public String editLetterDiary(@PathVariable("Id") Long Id, @RequestBody LetterDairyRequest letterdiaryrequest) {
		String ret = "";
		ResponseEntity<?> res = null;
		try 
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			LetterDiary letterDiary = letterdiaryrequest.getLetterDiary();
			if ("".equalsIgnoreCase(letterDiary.getLetter_number())) {
				res = ResponseEntity.status(400).body("Letter No. is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getReceived_from())) {
				res = ResponseEntity.status(400).body("Received_from is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getRefrence_no())) {
				res = ResponseEntity.status(400).body("Reference No is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if (letterDiary.getLetter_date() == null) {
				res = ResponseEntity.status(400).body("Letter Date is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getSubject())) {
				res = ResponseEntity.status(400).body("Subject is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if (letterDiary.getReceived_date() == null) {
				res = ResponseEntity.status(400).body("Received Date is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if("".equalsIgnoreCase(letterDiary.getSend_to_designation()))
			{
				res = ResponseEntity.status(400).body("Send to designation is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			if("".equalsIgnoreCase(letterDiary.getSend_to_division()))
			{
				res = ResponseEntity.status(400).body("Send to division is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			if (letterDiary.getDiary_date() == null) {
				res = ResponseEntity.status(400).body("Diary Date is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}			
			if ("".equalsIgnoreCase(letterDiary.getForm_of_communication())) {
				res = ResponseEntity.status(400).body("Form of Communication is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getLanguage())) {
				res = ResponseEntity.status(400).body("Language is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			if ("".equalsIgnoreCase(letterDiary.getRemarks())) {
				res = ResponseEntity.status(400).body("Remarks is required");
				return String.valueOf(res.getStatusCodeValue()) + "|" + res.getBody();
			}
			letterDiary.setCdt(new Date());
			letterDiary.setUser_id(user.getUserid());
			letterDiary.setStatus("active");			
			letterDiary.setSession_id(null);
			
			LetterDiary letterdiary = letterdiaryrepository.save(letterDiary);
						
			ContactDetails contactDetails = letterdiaryrequest.getContactDetails();
			contactDetails.setCdt(new Date());
			contactDetails.setStatus("active");
			contactDetails.setSessionid(null);
			contactDetails.setLetter_diary_id(letterdiary.getId());
			contactDetails.setUser_id(user.getUserid());
			
			contactdetailsrepository.save(contactDetails);
			
			res = ResponseEntity.status(200).body("Letter diary entry updated successfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
		}
		catch(Exception e)
		{
			res = ResponseEntity.status(400).body("Something went wrong, please try again after sometime");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			e.printStackTrace();
		}
		return ret;
	}
	
	@GetMapping("/ViewAllLetterDiaryEntry")
	public List<LetterDiary> ViewAllLetterDiaryEntry()
	{
		List<LetterDiary> ret = null;
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			ret = letterdiaryrepository.findAllByUserId(user.getUserid());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@GetMapping("/ViewLetterDiaryEntry/{Id}")
	public LetterDiaryResponse ViewFileDiaryEntry(@PathVariable("Id") Long Id)
	{
		LetterDiaryResponse ret = new LetterDiaryResponse();
		try
		{
			LetterDiary letterdiary = letterdiaryrepository.findByLetterId(Id);
			ContactDetails contactdetails = contactdetailsrepository.findByLetterDiaryId(letterdiary.getId());
			List<LetterMovementHistory> lettermovementhistory = lettermovementhistoryrepository.findByLetterId(Id);
			ret.setLetterdiary(letterdiary); 
			ret.setContactdetails(contactdetails);
			ret.setLettermovementhistory(lettermovementhistory); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@PostMapping("/searchLetterDiary")
	public List<LetterDiary> searchLetterDiary(@RequestBody SearchLetterDiaryRequest searchletterdiaryrequest)
	{
		List<LetterDiary> ret = null;
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			Date fromDate = null;
			Date toDate = null;
			if(searchletterdiaryrequest.getFrom_date() != null)
			{
				fromDate = Date.from(searchletterdiaryrequest.getFrom_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			}
			if(searchletterdiaryrequest.getTo_date() != null)
			{
				toDate = Date.from(searchletterdiaryrequest.getTo_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			}
			ret = letterdiaryrepository.searchLetterDiary(searchletterdiaryrequest.getLetter_no(), searchletterdiaryrequest.getReference_no(), searchletterdiaryrequest.getReceived_from(), searchletterdiaryrequest.getSubject(), fromDate, toDate, user.getUserid());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@PostMapping("/sendLetterMovementData")
	public String sendLetterMovementData(@RequestBody LetterMovementHistory lettermovementhistory)
	{
		String ret = "";
		ResponseEntity<?> res = null;
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			lettermovementhistory.setUser_id(user.getUserid());
			lettermovementhistory.setStatus("active");
			lettermovementhistory.setCdt(new Date());
			lettermovementhistory.setSession_id(null);
			lettermovementhistoryrepository.save(lettermovementhistory);
			res = ResponseEntity.status(200).body("Saved Record");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
}
