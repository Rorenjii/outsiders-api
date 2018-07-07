package org.outsiders.release.domain.constant;

public enum School {
	ABJURATION("abj"), 
	CONJURATION("con"), 
	DIVINATION("div"), 
	ENCHANTMENT("nch"), 
	EVOCATION("evo"), 
	ILLUSION("ilu"), 
	NECROMANCY("ncr"),
	TRANSMUTATION("trn");
	
	private String abbreviation;
	
	School(String abbreviation){
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}
