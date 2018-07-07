package org.outsiders.release.domain;

import org.outsiders.release.domain.constant.Alignment;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class CharacterDescription {

	private String name;
	private String playerName;
	private String homeland;
	private String deity;
	private Alignment alignment;
	private String gender;
	private String age;
	private String height;
	private String weight;
	private String hair;
	private String eyes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getHomeland() {
		return homeland;
	}
	public void setHomeland(String homeland) {
		this.homeland = homeland;
	}
	public String getDeity() {
		return deity;
	}
	public void setDeity(String deity) {
		this.deity = deity;
	}
	public Alignment getAlignment() {
		return alignment;
	}
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHair() {
		return hair;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	public String getEyes() {
		return eyes;
	}
	public void setEyes(String eyes) {
		this.eyes = eyes;
	}
	
	
}
