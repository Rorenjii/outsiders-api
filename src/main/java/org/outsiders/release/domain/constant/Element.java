package org.outsiders.release.domain.constant;

public enum Element {
	
	WATER("COLD"), EARTH("ACID"), FIRE("FIRE"), AIR("FORCE"), LIGHTNING("SHOCK");
	
	private String damageType;
	
	Element(String damageType) {this.damageType = damageType;}

	public String getDamageType() {
		return damageType;
	}
}
