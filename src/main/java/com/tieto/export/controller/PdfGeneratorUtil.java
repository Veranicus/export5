package com.tieto.export.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.tieto.export.data.structure.UserPersonalDataDto;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class PdfGeneratorUtil {
	
	@Autowired
	private Configuration freeMarkerConfig;
	/* auto-configured free marker config
	 * for specific config, create new class: PDFConfiguration extends Configuration
	 * add @Component to it, and add @Autowired to its consturtor, and delete it here
	 * (@Autowired, not variable)
	 */
	
	/**
	 * Processes user data and creates PDF document
	 * @param user
	 * @return Returns PDF in byte[]
	 * @throws IOException
	 * @throws TemplateException
	 * @throws DocumentException
	 */
	public byte[] generate(UserPersonalDataDto user) throws IOException,TemplateException,DocumentException {
		Template temp= freeMarkerConfig.getTemplate("pdfTemplate_img.ftl");
		
		Assert.notNull(temp, "The templateName can not be null");

		Map<String, Object> model= new HashMap<>();
		model.put("user", user);

    	return htmlToPdf(generateHTML(model, temp));
	}

	//Only for debug- generates pdf, but also keeps it in temp file folder as files (both html and pdf file)
	public File generateWithFiles(UserPersonalDataDto user) 
			throws IOException,TemplateException,DocumentException {
		Template temp= freeMarkerConfig.getTemplate("pdfTemplate_img.ftl");
		Assert.notNull(temp, "The templateName can not be null");

		Map<String, Object> model= new HashMap<>();
		model.put("user", user);
		
		File pdfFile= null;
		File htmlFile= File.createTempFile(UUID.randomUUID().toString(), ".html");
		OutputStreamWriter htmlStream= new OutputStreamWriter( new FileOutputStream(htmlFile));
    	temp.process(model, htmlStream);
    	pdfFile= File.createTempFile(UUID.randomUUID().toString(),".pdf");
		try (FileOutputStream pdfStream= new FileOutputStream(pdfFile)) {
			
			ITextRenderer renderer = new ITextRenderer();
            renderer.getSharedContext()
        	.setReplacedElementFactory(
        			new MediaReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));
            renderer.setDocument(htmlFile);
            renderer.layout();
            renderer.createPDF(pdfStream, false);
            renderer.finishPDF();
		}
        return pdfFile;
	}
	
	/**
	 * Generates html string by merging template with data
	 * @param model
	 * @param temp
	 * @return Returns html document in a string
	 * @throws IOException
	 * @throws TemplateException
	 */
	private String generateHTML(Map<String, Object> model, Template temp) throws IOException, TemplateException {
		
		ByteArrayOutputStream htmlBytes= new ByteArrayOutputStream();
    	temp.process(model, new OutputStreamWriter(htmlBytes));		//connecting data with html template
    	
    	return new String(htmlBytes.toByteArray(), StandardCharsets.UTF_8);
	}
	
	/**
	 * Converts html doc into pdf
	 * @param html
	 * @return
	 * @throws DocumentException
	 */
	private byte[] htmlToPdf(String html) throws IOException, DocumentException {
		//generating pdf
    	ByteArrayOutputStream pdfStream= new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        
        //adding image support (by replacing certain divs with image data)
        renderer
        	.getSharedContext()
        	.setReplacedElementFactory(new MediaReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));
        
        //adds support for unicode characters (ščř,...) TODO Does not work in JAR!
    	//String p= new ClassPathResource("fonts/PT_Serif.ttf").getFile().toPath().toString();
    	//renderer.getFontResolver().addFont("/opt/portal/microservices/export/PT_Serif.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(pdfStream, false);
        renderer.finishPDF();

        return pdfStream.toByteArray();
	}
}
