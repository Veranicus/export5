package com.tieto.export.data.structure;

public class UserPersonalDataServerDto {

	private String serverId;
	private String fqdn;
	private String name;
	private String authentication;

	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getFqdn() {
		return fqdn;
	}
	public void setFqdn(String fqdn) {
		this.fqdn = fqdn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getAuthentication() {
		return authentication;
	}
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
}

