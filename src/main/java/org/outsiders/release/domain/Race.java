package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	private List<ModMap> modifiers;
	private List<String> abilityIds;
	private Size size;
	
	public Race() {
		String id = UUID.randomUUID().toString();
		this.id = id;
	}
	
	public void updateRace(Race a) throws Exception {
    	if(this.getId().equals(a.getId())) {
			if(a.getVariant() != null) { 
				this.setVariant(a.getVariant());
			}
			if(a.getType() != null) {
				this.setType(a.getType());
			}
			if(a.getSize() != null) {
				this.setSize(a.getSize());
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
	public List<ModMap> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<ModMap> modifiers) {
		this.modifiers = modifiers;
	}
	public List<String> getAbilityIds() {
		return abilityIds;
	}
	public void setAbilityIds(List<String> abilityIds) {
		this.abilityIds = abilityIds;
	}
}
