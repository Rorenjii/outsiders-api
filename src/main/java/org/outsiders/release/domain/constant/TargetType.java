package org.outsiders.release.domain.constant;

public enum TargetType {
	
	SELF("S"), CREATURE("C"), HUMANOID("H"), ITEM("I"), GROUP("G"), AOE("A");
	
	private String abbreviation;
	
	TargetType(String abbreviation){
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
}
