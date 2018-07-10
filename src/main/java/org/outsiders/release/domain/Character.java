package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	private List<ModMap> modifiers;
	private CharacterDescription characterDescription;
	
	public Character() {
		String id = UUID.randomUUID().toString();
		this.id = id;
	}

	public void updateCharacter(Character c) throws Exception {
		if(this.getId().equals(c.getId())) {
			if(c.getInventory() != null) { 
				this.setInventory(c.getInventory());
			}
			if(c.getClassLevelIds() != null) {
				if (!c.getClassLevelIds().isEmpty()) {
					this.setClassLevelIds(c.getClassLevelIds());
				}	
			}
			if(c.getFeatAbilityIds() != null) {
				if (!c.getFeatAbilityIds().isEmpty()) {
					this.setFeatAbilityIds(c.getFeatAbilityIds());
				}	
			}
			if(c.getModifiers() != null) {
				if (!c.getModifiers().isEmpty()) {
					this.setModifiers(c.getModifiers());
				}	
			}
			if(c.getRaceId() != null) {
				if (!c.getRaceId().isEmpty()) {
					this.setRaceId(c.getRaceId());
				}	
			}
			if(c.getCharacterDescription() != null) { 
				this.setCharacterDescription(c.getCharacterDescription());
			}
		} else {
			throw new Exception("ID MISMATCH");
		}
	}

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

	public List<ModMap> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<ModMap> modifiers) {
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