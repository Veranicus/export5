package com.tieto.export.data.structure;

import java.util.List;
import java.util.Map;

public class AurUserPersonalDataDto {

	private Map<String, String> fields;
	private List<AurEntityWithRolesDto> entities;
	
	public Map<String, String> getFields() {
		return fields;
	}
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
	public void addFields(String key, String value) {
		this.fields.put(key, value);
	}
	public List<AurEntityWithRolesDto> getEntities() {
		return entities;
	}
	public void setEntities(List<AurEntityWithRolesDto> entities) {
		this.entities = entities;
	}
}
