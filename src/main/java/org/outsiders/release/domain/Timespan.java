package org.outsiders.release.domain;

import org.outsiders.release.domain.constant.Per;
import org.outsiders.release.domain.constant.TimeUnit;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Timespan {
	
	private TimeUnit unit;
	private int value;
	private Per per;

	public Per getPer() {
		return per;
	}
	public void setPer(Per per) {
		this.per = per;
	}
	public TimeUnit getUnit() {
		return unit;
	}
	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
