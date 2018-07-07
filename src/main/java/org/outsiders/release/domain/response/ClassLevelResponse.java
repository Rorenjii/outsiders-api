package org.outsiders.release.domain.response;

import java.util.List;

import org.outsiders.release.domain.ClassLevel;

public class ClassLevelResponse {
	
	private List<ClassLevel> classLevels;
	private boolean success;
	private String errorCode;
	
	public List<ClassLevel> getClassLevels() {
		return classLevels;
	}
	public void setClassLevels(List<ClassLevel> classLevels) {
		this.classLevels = classLevels;
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
