package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.outsiders.release.domain.constant.ItemType;
import org.outsiders.release.domain.constant.ModifierType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
public class Item {
	
    @PrimaryKey
    private String id;
	
	private String name;
	private String description;
	private List<ModMap> modifiers;
	private List<ItemType> types;
	private List<String> abilityIds;
	
	public Item() {
		String id = UUID.randomUUID().toString();
		this.id = id;
	}
	
	@JsonIgnore
	public boolean isEquippable() {
		return types.contains(ItemType.EQUIPPABLE);
	}
	@JsonIgnore
	public boolean isMagical() {
		return types.contains(ItemType.MAGICAL) || types.contains(ItemType.ATTUNABLE);
	}
	@JsonIgnore
	public boolean isAttunable() {
		return types.contains(ItemType.ATTUNABLE);
	}
	@JsonIgnore
	public boolean isConsumable() {
		return types.contains(ItemType.CONSUMABLE);
	}
	
	public void updateItem(Item a) throws Exception {
    	if(this.getId().equals(a.getId())) {
			if(a.getName() != null) { 
				this.setName(a.getName());
			}
			if(a.getTypes() != null) {
				if (!a.getTypes().isEmpty()) {
					this.setTypes(a.getTypes());
				}	
			}
			if(a.getDescription() != null) {
				if (!a.getDescription().isEmpty()) {
					this.setDescription(a.getDescription());
				}	
			}
			if(a.getModifiers() != null) {
				if (!a.getModifiers().isEmpty()) {
					this.setModifiers(a.getModifiers());
				}
			}
			if(a.getAbilityIds() != null) {
				if (!a.getAbilityIds().isEmpty()) {
					this.setAbilityIds(a.getAbilityIds());
				}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ModMap> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<ModMap> modifiers) {
		this.modifiers = modifiers;
	}
	public List<ItemType> getTypes() {
		return types;
	}
	public void setTypes(List<ItemType> types) {
		this.types = types;
	}
	public List<String> getAbilityIds() {
		return abilityIds;
	}
	public void setAbilityIds(List<String> abilityIds) {
		this.abilityIds = abilityIds;
	}
}
