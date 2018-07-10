package org.outsiders.release.domain;

import org.outsiders.release.domain.constant.D;
import org.outsiders.release.domain.constant.ModifierType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class ModMap {

	private ModifierType modifier;
	private int value;
	private D d;
	
	public ModifierType getModifier() {
		return modifier;
	}
	public void setModifier(ModifierType modifier) {
		this.modifier = modifier;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public D getD() {
		return d;
	}
	public void setD(D d) {
		this.d = d;
	}
}
