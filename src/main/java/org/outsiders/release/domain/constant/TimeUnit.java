package org.outsiders.release.domain.constant;

public enum TimeUnit {
	
	SECOND("s"), MINUTE("m"), HOUR("h"), DAY("D"), WEEK("W"), MONTH("M"), YEAR("Y"),
	ROUND("R"), FULLROUND("F");
	
	private String abbreviation;
	
	TimeUnit(String abbreviation){
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}
