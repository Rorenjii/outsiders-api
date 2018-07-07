package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;

import org.outsiders.release.domain.constant.ModifierType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Character {
	
    @PrimaryKey
    private String id;
	
	private Inventory inventory;
	private List<String> classLevelIds;
	private List<String> featAbilityIds;
	private String raceId;
	private Map<ModifierType, Integer> modifiers;
	private CharacterDescription characterDescription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<String> getClassLevelIds() {
		return classLevelIds;
	}

	public void setClassLevelIds(List<String> classLevelIds) {
		this.classLevelIds = classLevelIds;
	}

	public List<String> getFeatAbilityIds() {
		return featAbilityIds;
	}

	public void setFeatAbilityIds(List<String> featAbilityIds) {
		this.featAbilityIds = featAbilityIds;
	}

	public String getRaceId() {
		return raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}

	public Map<ModifierType, Integer> getModifiers() {
		return modifiers;
	}

	public void setModifiers(Map<ModifierType, Integer> modifiers) {
		this.modifiers = modifiers;
	}

	public CharacterDescription getCharacterDescription() {
		return characterDescription;
	}

	public void setCharacterDescription(CharacterDescription characterDescription) {
		this.characterDescription = characterDescription;
	}
	
	//methods for returning all abilities and attacks and rolls etc
}