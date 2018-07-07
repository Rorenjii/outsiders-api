package org.outsiders.release.domain;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Inventory {

	private List<String> itemIds;
	private int size;
	private Wallet wallet;

	public List<String> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
}
