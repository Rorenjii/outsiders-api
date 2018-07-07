package org.outsiders.release.domain.response;

import java.util.List;

import org.outsiders.release.domain.Character;

public class CharacterResponse {
	
	private List<Character> characters;
	private boolean success;
	private String errorCode;
	
	public List<Character> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Character> characters) {
		this.characters = characters;
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
