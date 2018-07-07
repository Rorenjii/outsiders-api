package org.outsiders.release.domain.response;

import java.util.List;

import org.outsiders.release.domain.Race;

public class RaceResponse {
	
	private List<Race> races;
	private boolean success;
	private String errorCode;
	
	public List<Race> getRaces() {
		return races;
	}
	public void setRaces(List<Race> races) {
		this.races = races;
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
