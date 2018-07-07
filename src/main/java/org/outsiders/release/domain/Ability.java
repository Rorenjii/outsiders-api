package org.outsiders.release.domain;

import java.util.Map;

import org.outsiders.release.domain.constant.AbilityType;
import org.outsiders.release.domain.constant.ModifierType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Ability {
	
    @PrimaryKey
    private String id;
	
	private AbilityType type;
	private String name;
	private String description;
	private Map<ModifierType, Integer> modifiers;
	private Timespan timespan;
	private Target target;
	private SpellInfo spellInfo;
	
	public boolean isSpell() {
		return type == AbilityType.SPELL;
	}
	public boolean isRacial() {
		return type == AbilityType.RACIAL;
	}
	public boolean isClass() {
		return type == AbilityType.CLASS;
	}
	public boolean isFeat() {
		return type == AbilityType.FEAT;
	}
	public boolean isItem() {
		return type == AbilityType.ITEM;
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
	public Map<ModifierType, Integer> getModifiers() {
		return modifiers;
	}
	public void setModifiers(Map<ModifierType, Integer> modifiers) {
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
