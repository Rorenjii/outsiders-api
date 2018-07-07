package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;

import org.outsiders.release.domain.constant.ModifierType;
import org.outsiders.release.domain.constant.RaceType;
import org.outsiders.release.domain.constant.Size;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Race {

	@PrimaryKey
    private String id;
    
	private RaceType type;
	private String variant;
	private Map<ModifierType, Integer> modifiers;
	private List<String> abilityIds;
	private Size size;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public RaceType getType() {
		return type;
	}
	public void setType(RaceType type) {
		this.type = type;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public Map<ModifierType, Integer> getModifiers() {
		return modifiers;
	}
	public void setModifiers(Map<ModifierType, Integer> modifiers) {
		this.modifiers = modifiers;
	}
	public List<String> getAbilityIds() {
		return abilityIds;
	}
	public void setAbilityIds(List<String> abilityIds) {
		this.abilityIds = abilityIds;
	}
}
