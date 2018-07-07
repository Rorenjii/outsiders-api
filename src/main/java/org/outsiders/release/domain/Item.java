package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;

import org.outsiders.release.domain.constant.ItemType;
import org.outsiders.release.domain.constant.ModifierType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Item {
	
    @PrimaryKey
    private String id;
	
	private String name;
	private String description;
	private Map<ModifierType, Integer> modifiers;
	private Integer quantity;
	private List<ItemType> types;
	private List<String> abilityIds;
	
	public boolean isEquippable() {
		return types.contains(ItemType.EQUIPPABLE);
	}
	public boolean isMagical() {
		return types.contains(ItemType.MAGICAL) || types.contains(ItemType.ATTUNABLE);
	}
	public boolean isAttunable() {
		return types.contains(ItemType.ATTUNABLE);
	}
	public boolean isConsumable() {
		return types.contains(ItemType.CONSUMABLE);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public Map<ModifierType, Integer> getModifiers() {
		return modifiers;
	}
	public void setModifiers(Map<ModifierType, Integer> modifiers) {
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
