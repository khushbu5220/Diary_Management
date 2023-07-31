package com.filediarysystem.restcontroller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.filediarysystem.config.JwtAuthenticationFilter;
import com.filediarysystem.entities.FileDiary;
import com.filediarysystem.entities.FileMovementHistory;
import com.filediarysystem.entities.User;
import com.filediarysystem.helper.CustomUserDetails;
import com.filediarysystem.payload.request.SearchFileDiaryRequest;
import com.filediarysystem.payload.response.FileDiaryResponse;
import com.filediarysystem.repositories.FileDiaryRepository;
import com.filediarysystem.repositories.FileMovementHistoryRepository;
import com.filediarysystem.repositories.UserRepository;
import com.filediarysystem.services.CustomUserDetailsService;

import lombok.AllArgsConstructor;
//import com.filediarysystem.helper;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class FileDiaryRestController
{
	@Autowired
	FileDiaryRepository filediaryrepository;
	@Autowired
	JwtAuthenticationFilter JwtAuthentication;
	@Autowired
	UserRepository userrepository;
	@Autowired
	FileMovementHistoryRepository filemovementhistoryrepository;
	
	@PostMapping("/saveFileDiaryEntry")
	public String saveFileDiaryEntry(@RequestBody FileDiary filediary)
	{
		String ret = "";
		String Username = JwtAuthentication.checkName();
		User user = userrepository.findByUsername(Username);
		ResponseEntity<?> res = null;
		try
		{
			FileDiary fd = new FileDiary();
			if("".equalsIgnoreCase(filediary.getFile_no()))
			{
				res = ResponseEntity.status(400).body("File No. is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setFile_no(filediary.getFile_no());
			if(filediary.getFile_date() == null)
			{
				res = ResponseEntity.status(400).body("File Date is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setFile_date(filediary.getFile_date());
			if("".equalsIgnoreCase(filediary.getSubject()))
			{
				res = ResponseEntity.status(400).body("Subject is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setSubject(filediary.getSubject());
			if("".equalsIgnoreCase(filediary.getReceived_from()))
			{
				res = ResponseEntity.status(400).body("Received from is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setReceived_from(filediary.getReceived_from());
			if(filediary.getReceived_date() == null)
			{
				res = ResponseEntity.status(400).body("Received Date is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setReceived_date(filediary.getReceived_date());
			if("".equalsIgnoreCase(filediary.getReference_no()))
			{
				res = ResponseEntity.status(400).body("Reference No. is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setReference_no(filediary.getReference_no());
			if("".equalsIgnoreCase(filediary.getRemarks()))
			{
				res = ResponseEntity.status(400).body("Remarks is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setRemarks(filediary.getRemarks());
			if("".equalsIgnoreCase(filediary.getSend_to_designation()))
			{
				res = ResponseEntity.status(400).body("Send to designation is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setSend_to_designation(filediary.getSend_to_designation());
			if("".equalsIgnoreCase(filediary.getSend_to_division()))
			{
				res = ResponseEntity.status(400).body("Send to division is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setSend_to_division(filediary.getSend_to_division());
			fd.setUser_id(user.getUserid());
			fd.setStatus("active");
			fd.setCdt(new Date());
			fd.setSession_id(null);
			filediaryrepository.save(fd);
			res = ResponseEntity.status(201).body("File diary entry saved successfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
		}
		catch(Exception e)
		{
			res = ResponseEntity.status(400).body("Something went wrong, please try after sometime");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			e.printStackTrace();
		}
		return ret;
	}
	
	@PutMapping("/editFileDiaryEntry/{Id}")
	public String editFileDiaryEntry(@PathVariable("Id") Long Id,@RequestBody FileDiary filediary)
	{
		String ret = "";
		ResponseEntity<?> res = null;
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			FileDiary fd = new FileDiary();
			fd.setId(Id);
			if("".equalsIgnoreCase(filediary.getFile_no()))
			{
				res = ResponseEntity.status(400).body("File No. is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setFile_no(filediary.getFile_no());
			if(filediary.getFile_date() == null)
			{
				res = ResponseEntity.status(400).body("File Date is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setFile_date(filediary.getFile_date());
			if("".equalsIgnoreCase(filediary.getSubject()))
			{
				res = ResponseEntity.status(400).body("Subject is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setSubject(filediary.getSubject());
			if("".equalsIgnoreCase(filediary.getReceived_from()))
			{
				res = ResponseEntity.status(400).body("Received from is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setReceived_from(filediary.getReceived_from());
			if(filediary.getReceived_date() == null)
			{
				res = ResponseEntity.status(400).body("Received Date is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setReceived_date(filediary.getReceived_date());
			if("".equalsIgnoreCase(filediary.getReference_no()))
			{
				res = ResponseEntity.status(400).body("Reference No. is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setReference_no(filediary.getReference_no());
			if("".equalsIgnoreCase(filediary.getRemarks()))
			{
				res = ResponseEntity.status(400).body("Remarks is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setRemarks(filediary.getRemarks());
			if("".equalsIgnoreCase(filediary.getSend_to_designation()))
			{
				res = ResponseEntity.status(400).body("Send to designation is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setSend_to_designation(filediary.getSend_to_designation());
			if("".equalsIgnoreCase(filediary.getSend_to_division()))
			{
				res = ResponseEntity.status(400).body("Send to division is required");
				return String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			}
			fd.setSend_to_division(filediary.getSend_to_division());
			fd.setUser_id(user.getUserid());
			fd.setStatus("active");
			fd.setCdt(new Date());
			fd.setSession_id(null);
			filediaryrepository.save(fd);
			res = ResponseEntity.status(200).body("File diary entry edited successfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
		}
		catch(Exception e)
		{
			res = ResponseEntity.status(400).body("File diary entry edited unsuccessfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
			e.printStackTrace();
		}
		return ret;
	}
	
	
	@GetMapping("/ViewAllFileDiaryEntry")
	public List<FileDiary> ViewAllFileDiaryEntry()
	{
		String Username = JwtAuthentication.checkName();
		User user = userrepository.findByUsername(Username);
		List<FileDiary> ret = null;
		try
		{
			ret = filediaryrepository.findAllByUserId(user.getUserid());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@GetMapping("/ViewFileDiaryEntry/{Id}")
	public FileDiaryResponse ViewFileDiaryEntry(@PathVariable("Id") Long Id)
	{
		FileDiaryResponse ret = new FileDiaryResponse();
		try
		{
			FileDiary filediary = filediaryrepository.findByfile_Id(Id);
			List<FileMovementHistory> filemovementhistory = filemovementhistoryrepository.findByFileId(Id);
			ret.setFilediary(filediary); 
			ret.setFilemovementhistory(filemovementhistory); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@PostMapping("/searchFileDiary")
	public List<FileDiary> searchFileDiary(@RequestBody SearchFileDiaryRequest searchfilediaryrequest)
	{
		List<FileDiary> ret = null;
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			Date fromDate = null;
			Date toDate = null;
			if(searchfilediaryrequest.getFrom_date() != null)
			{
				fromDate = Date.from(searchfilediaryrequest.getFrom_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			}
			if(searchfilediaryrequest.getTo_date() != null)
			{
				toDate = Date.from(searchfilediaryrequest.getTo_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			}
			
			ret = filediaryrepository.searchFileDiary(searchfilediaryrequest.getFile_no(), searchfilediaryrequest.getReference_no(), searchfilediaryrequest.getReceived_from(), searchfilediaryrequest.getSubject(), fromDate, toDate, user.getUserid());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
//	@PostMapping("/updateFileMovementData")
//	public String updateFileMovementData(@RequestBody FileMovementHistory filemovementhistory)
//	{
//		String ret = "";
//		try
//		{
//			filemovementhistory.setStatus("active");
//			filemovementhistory.setCdt(new Date());
//			filemovementhistory.setSession_id(null);
//			filemovementhistoryrepository.save(filemovementhistory);
//			ret = "Saved Record";
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return ret;
//	}

	@PostMapping("/sendFileMovementData")
	public String sendFileMovementData(@RequestBody FileMovementHistory filemovementhistory)
	{
		String ret = "";
		ResponseEntity<?> res = null;
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			filemovementhistory.setUser_id(user.getUserid());
			filemovementhistory.setStatus("active");
			filemovementhistory.setCdt(new Date());
			filemovementhistory.setSession_id(null);
			filemovementhistoryrepository.save(filemovementhistory);
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
