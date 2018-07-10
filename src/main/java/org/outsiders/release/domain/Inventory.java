package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Inventory {

	private Map<String, Integer> itemIds;
	private int size;
	private Wallet wallet;

	public Map<String, Integer> getItemIds() {
		return itemIds;
	}
	public void setItemIds(Map<String, Integer> itemIds) {
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
