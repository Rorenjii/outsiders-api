package org.outsiders.release.domain;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Wallet {


	private Integer copper;
	private Integer silver;
	private Integer gold;
	private Integer platinum;
	
	public Integer getCopper() {
		return copper;
	}
	public void setCopper(Integer copper) {
		this.copper = copper;
	}
	public Integer getSilver() {
		return silver;
	}
	public void setSilver(Integer silver) {
		this.silver = silver;
	}
	public Integer getGold() {
		return gold;
	}
	public void setGold(Integer gold) {
		this.gold = gold;
	}
	public Integer getPlatinum() {
		return platinum;
	}
	public void setPlatinum(Integer platinum) {
		this.platinum = platinum;
	}
}
