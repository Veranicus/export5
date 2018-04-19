package com.tieto.export.data.structure;

public class UserPersonalDataSaasDto extends UserPersonalDataServerDto {

	private String profileUrl;
	private AurUserPersonalDataDto aurUserPersonalData;

	public AurUserPersonalDataDto getAurUserPersonalData() {
		return aurUserPersonalData;
	}
	public void setAurUserPersonalData(AurUserPersonalDataDto aurUserPersonalData) {
		this.aurUserPersonalData = aurUserPersonalData;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
}
