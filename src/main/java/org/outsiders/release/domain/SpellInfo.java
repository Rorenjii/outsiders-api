package org.outsiders.release.domain;

import org.outsiders.release.domain.constant.School;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class SpellInfo {

	private int spellLevel;
	private School school;
	private boolean arcane;
	private boolean divine;

	public int getSpellLevel() {
		return spellLevel;
	}
	public void setSpellLevel(int spellLevel) {
		this.spellLevel = spellLevel;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public boolean isArcane() {
		return arcane;
	}
	public void setArcane(boolean arcane) {
		this.arcane = arcane;
	}
	public boolean isDivine() {
		return divine;
	}
	public void setDivine(boolean divine) {
		this.divine = divine;
	}
	
	
}
