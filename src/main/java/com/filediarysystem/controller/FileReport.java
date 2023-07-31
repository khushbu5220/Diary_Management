package com.filediarysystem.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import com.filediarysystem.config.JwtAuthenticationFilter;
import com.filediarysystem.entities.FileDiary;
import com.filediarysystem.entities.FileMovementHistory;
import com.filediarysystem.payload.response.FileMovementHistoryReportResponse;
import com.filediarysystem.repositories.FileDiaryRepository;
import com.filediarysystem.repositories.FileMovementHistoryRepository;
import com.filediarysystem.repositories.UserRepository;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class FileReport 
{
	@Autowired
	FileDiaryRepository filediaryrepository;
	@Autowired
	JwtAuthenticationFilter JwtAuthentication;
	@Autowired
	UserRepository userrepository;
	@Autowired
	FileMovementHistoryRepository filemovementhistoryrepository;
	
	public static JasperDesign jasperDesign;
    public static JasperPrint jasperPrint;
    public static JasperReport jasperReport;
    public static String reportTemplateUrl = "C:\\img\\FileReport.jrxml";  //classpath:templates/reports/FileReport.jrxml
	
	@GetMapping("/getFileReport/{Id}")
	public String getFileReport(@PathVariable("Id") Long fileId,  HttpServletRequest request, HttpServletResponse response) // ResponseEntity<byte[]>
	{
//		ResponseEntity<byte[]> ret = null;
		String ret = "";
		try
		{
				String jasperDesign = ResourceUtils.getFile(reportTemplateUrl).getAbsolutePath();
			    
	            jasperReport = JasperCompileManager.compileReport(jasperDesign);
	            
	            List<FileMovementHistory> data = filemovementhistoryrepository.findByFileId(fileId);
	            List<FileMovementHistoryReportResponse> fmhrr = new ArrayList<>();
	            for(FileMovementHistory f : data)
	            {
	            	FileMovementHistoryReportResponse filemovementhistory = new FileMovementHistoryReportResponse();
	            	filemovementhistory.setCdt(f.getCdt().toString());
	            	if(f.getReceived_date() != null)
	            		filemovementhistory.setReceived_date(f.getReceived_date().toString());
	            	else
	            		filemovementhistory.setReceived_date("");
	            	if(f.getReceived_date() != null)
	            		filemovementhistory.setSend_date(f.getSend_date().toString());
	            	else
	            		filemovementhistory.setSend_date("");
	            	filemovementhistory.setRemarks(f.getRemarks());
	            	filemovementhistory.setSend_to_division(f.getSend_to_division());
	            	fmhrr.add(filemovementhistory);
	            }
	            
	            FileDiary parameters = filediaryrepository.findByfile_Id(fileId);
	            Map<String, Object> map = new HashMap<>();
	            map.put("file_no", parameters.getFile_no());
	            map.put("reference_no", parameters.getReference_no());
	            map.put("recieved_from", parameters.getReceived_from());
	            map.put("received_date", parameters.getReceived_date().toString());
	            map.put("subject", parameters.getSubject());
	            map.put("file_date", parameters.getFile_date().toString());
	            map.put("send_to_designation", parameters.getSend_to_designation());
	            map.put("send_to_division", parameters.getSend_to_division());
	            map.put("remarks", parameters.getRemarks());
	            map.put("cdt", parameters.getCdt().toString());
	            map.put("FileMovementHistory", new JRBeanCollectionDataSource(fmhrr));
	            

	            
	            jasperPrint = JasperFillManager.fillReport(jasperReport, map,
	                    new JREmptyDataSource());
	            HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_PDF);
//				headers.setContentDispositionFormData("filename", "FileReport.pdf");
				response.addHeader("content-disposition", "attachment; filename=FileReport.pdf");
				
				
				
				String home = System.getProperty("user.home");
//				System.out.println("home : "+home);
				String filePath = home+"\\Downloads\\FileReport_"+System.currentTimeMillis()+".pdf";
				JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);

//				Document document = new Document();
//			    PdfWriter writer = PdfWriter.getInstance(document,
//			      new FileOutputStream("src/output/html.pdf"));
//			    document.open();
//			    XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//			      new FileInputStream(filename));
//			    document.close();
//				
//				File s = new File("C:\\Users\\Khushbu\\Downloads");
//				RandomAccessFile raf1 = new RandomAccessFile(s, "r");
//				long l1 = raf1.length();
//				byte abyte1[] = new byte[(int)l1];
//				raf1.read(abyte1);
//				raf1.close();
//				
////				fileDownload("C:\\Users\\Khushbu\\Downloads", "application/pdf");
//				File file1 = new File("C:\\Users\\Khushbu\\Downloads");
//				Filedownload.save(file, "application/pdf");
//				ret = new ResponseEntity<byte[]>
//				(JasperExportManager.exportReportToPdf(jasperPrint), headers, HttpStatus.OK);
//						jasperPrint+"|"+ home+"\\Downloads\\FileReport_"+System.currentTimeMillis()+".pdf";
				ret = filePath;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
}
