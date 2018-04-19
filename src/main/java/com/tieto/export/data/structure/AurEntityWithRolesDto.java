package com.tieto.export.data.structure;

import java.util.List;

public class AurEntityWithRolesDto extends AurEntityDto {

	private List<String> userroles;
	private String entname;

	public List<String> getUserRoles() {
		return userroles;
	}

	public void setUserRoles(List<String> userroles) {
		this.userroles = userroles;
	}

	public String getEntname() {
		return entname;
	}

	public void setEntname(String entname) {
		this.entname = entname;
	}
}
