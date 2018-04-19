package com.tieto.export.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.tieto.export.data.structure.UserPersonalDataDto;

import freemarker.template.TemplateException;

@RestController
public class ExportController {
	
	private static final Logger log=  LoggerFactory.getLogger(ExportController.class);
	
	@Autowired
	private PdfGeneratorUtil pdfGeneratorUtil;
	
	@Autowired
	private VCardGeneratorUtil vCardGeneratorUtil;
	
	@RequestMapping(value="/export", method= RequestMethod.POST)
	public ResponseEntity<byte[]> export(@RequestBody UserPersonalDataDto user,
			@RequestParam(value="type", required=false, defaultValue="pdf") String fileType) {
		
		log.info("Exporting {0}", fileType);
		switch(fileType) {
		case "pdf":
			return toPdf(user);
		case "vcard":
			return toVCard(user);
		default:
			return null;
		}
	}

	//wrapping byte[] in response entity
	private ResponseEntity<byte[]> createResponseEntity(byte[] b, String name, MediaType t) throws IOException {
		
		HttpHeaders header= new HttpHeaders();
		header.setContentType(t);
		header.add("content-disposition",  "inline-filename=" + name);
		header.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		return new ResponseEntity<>(b, header, HttpStatus.OK);
	}
	
	
	private ResponseEntity<byte[]> toVCard(UserPersonalDataDto user) {
		ResponseEntity<byte[]> r= null;
		
		try {
			byte[] b= vCardGeneratorUtil.generate(user);
			r= createResponseEntity(b, "tmpVCard", MediaType.parseMediaType("text/vcard"));
			log.debug("vCard Export successfull");
			
		} catch(IOException e) {
			log.error("vCard Export: IO error");
		} catch(Exception e) {
			log.error("vCard Export: vCard failed to export");
		}
		return r;
	}
	
	//generate PDF file
	private ResponseEntity<byte[]> toPdf(UserPersonalDataDto user) {
		
		ResponseEntity<byte[]> r= null;
		try {
			//r= createResponseEntity(pdfGeneratorUtil.generateWithFiles(user).getPath().getBytes(), "tmpPdf", MediaType.parseMediaType("application/pdf"));
			byte[] b= pdfGeneratorUtil.generate(user);
			r= createResponseEntity(b, "tmpPdf", MediaType.parseMediaType("application/pdf"));
			log.info("PDF Export successfull");
			
		} catch(IOException e) {
			log.error("PDF Export: IO error", e);
		} catch(DocumentException e) {
			log.error("PDF Export: PDF failed to convert", e);
		} catch(TemplateException e) {
			log.error("PDF Export: template processing error", e);
		} catch(Exception e) {
			log.error("PDF Export: " + e.getMessage(), e);
		}
		return r;
	}
}
