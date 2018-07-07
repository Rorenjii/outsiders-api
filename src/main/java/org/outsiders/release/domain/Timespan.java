package org.outsiders.release.domain;

import org.outsiders.release.domain.constant.TimeUnit;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Timespan {
	
	private TimeUnit unit;
	private int value;

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
