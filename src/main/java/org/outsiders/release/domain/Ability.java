package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.outsiders.release.domain.constant.AbilityType;
import org.outsiders.release.domain.constant.ModifierType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
public class Ability {
	
    @PrimaryKey
    private String id;
	
	private AbilityType type;
	private String name;
	private String description;
	private List<ModMap> modifiers;
	private Timespan timespan;
	private Target target;
	private SpellInfo spellInfo;
	
	public Ability() {
		String id = UUID.randomUUID().toString();
		this.id = id;
	}
	
	@JsonIgnore
	public boolean isSpell() {
		return type == AbilityType.SPELL;
	}
	@JsonIgnore
	public boolean isRacial() {
		return type == AbilityType.RACIAL;
	}
	@JsonIgnore
	public boolean isClass() {
		return type == AbilityType.CLASS;
	}
	@JsonIgnore
	public boolean isFeat() {
		return type == AbilityType.FEAT;
	}
	@JsonIgnore
	public boolean isItem() {
		return type == AbilityType.ITEM;
	}
	@JsonIgnore
	public boolean isPassive() {
		return type == AbilityType.PASSIVE;
	}
	
	public void updateAbility(Ability a) throws Exception {
    	if(this.getId().equals(a.getId())) {
			if(a.getName() != null) { 
				this.setName(a.getName());
			}
			if(a.getType() != null) {
				this.setType(a.getType());
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
			if(a.getTimespan() != null) {
				this.setTimespan(a.getTimespan());
			}
			if(a.getTarget() != null) {
				this.setTarget(a.getTarget());
			}
			if(a.getSpellInfo() != null) {
				this.setSpellInfo(a.getSpellInfo());
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
	public Timespan getTimespan() {
		return timespan;
	}
	public void setTimespan(Timespan duration) {
		this.timespan = duration;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public AbilityType getType() {
		return type;
	}
	public void setType(AbilityType type) {
		this.type = type;
	}
	public SpellInfo getSpellInfo() {
		return spellInfo;
	}
	public void setSpellInfo(SpellInfo spellInfo) {
		this.spellInfo = spellInfo;
	}
}
