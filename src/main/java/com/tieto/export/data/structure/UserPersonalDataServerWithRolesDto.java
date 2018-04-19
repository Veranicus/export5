package com.tieto.export.data.structure;

import java.util.List;

public class UserPersonalDataServerWithRolesDto extends UserPersonalDataServerDto {

	private List<String> serverRoles;

	public List<String> getServerRoles() {
		return serverRoles;
	}

	public void setServerRoles(List<String> serverRoles) {
		this.serverRoles = serverRoles;
	}
}
