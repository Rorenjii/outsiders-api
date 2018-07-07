package org.outsiders.release.domain.response;

import java.util.List;

import org.outsiders.release.domain.Item;

public class ItemResponse {
	
	private List<Item> items;
	private boolean success;
	private String errorCode;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
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
