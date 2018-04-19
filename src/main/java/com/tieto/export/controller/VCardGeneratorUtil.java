package com.tieto.export.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tieto.export.data.structure.UserPersonalDataDto;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.io.text.VCardWriter;
import ezvcard.parameter.EmailType;
import ezvcard.property.StructuredName;

@Component
public class VCardGeneratorUtil {

	/**
	 * Generates vcard based on given user data
	 * @param user
	 * @return Returns byte[] representation of vcard
	 * @throws IOException
	 */
	public byte[] generate(UserPersonalDataDto user) throws IOException {
		
		VCard vc= populateVCard(user);
		
		ByteArrayOutputStream vcStream= new ByteArrayOutputStream();
		VCardWriter writer = new VCardWriter(vcStream, VCardVersion.V4_0);
		
		writer.write(vc);
		writer.close();
		
		return vcStream.toByteArray();
	}
	
	/**
	 * Generates vcard from given user, creates file with vcard in temp. files folder
	 * @param user
	 * @return Returns byte[] representation of vcard
	 * @throws IOException
	 */
	public File generateWithFiles(UserPersonalDataDto user) throws IOException {

		VCard vc= populateVCard(user);
		
		/* Creates extended property with json formatted user.companies
			ObjectMapper mapper= new ObjectMapper();
			vc.setExtendedProperty("SSH", user.getSshKey());
			vc.setExtendedProperty("COMPANIES", mapper.writeValueAsString(user.getCompanies()));
	
			//For writing data in xml instead of json
			//String xml= "";
			//vc.addXml(new Xml(xml));
		*/

		//creates temporary vCard file
    	File tmpFile= File.createTempFile(UUID.randomUUID().toString(), ".vcf");
		try (VCardWriter writer = new VCardWriter(tmpFile, VCardVersion.V4_0)) {
			writer.write(vc);
		}
		
		return tmpFile;
	}
	
	/**
	 * Receives user data and transforms them into vcard
	 * @param user
	 * @return Returns vcard object
	 */
	private VCard populateVCard(UserPersonalDataDto user) {
		VCard vc= new VCard();

		StructuredName n= new StructuredName();
		n.setFamily(user.getLastname());
		n.setGiven(user.getFirstname());
		vc.setStructuredName(n);
		vc.setFormattedName(user.getFullname());
		vc.addEmail(user.getEmail(), EmailType.WORK);
		
		return vc;
	}
}
