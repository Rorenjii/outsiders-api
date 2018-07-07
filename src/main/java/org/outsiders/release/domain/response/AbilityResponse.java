package org.outsiders.release.domain.response;

import java.util.List;

import org.outsiders.release.domain.Ability;

public class AbilityResponse {
	
	private List<Ability> abilities;
	private boolean success;
	private String errorCode;
	
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
