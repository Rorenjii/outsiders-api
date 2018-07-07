package org.outsiders.release.domain;

import java.util.List;
import java.util.Map;

import org.outsiders.release.domain.constant.ClassType;
import org.outsiders.release.domain.constant.ModifierType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class ClassLevel {
	
    @PrimaryKey
    private String id;
	
	private int level;
	private ClassType classType;
	private List<String> innateAbilityIds;
	private List<String> chosenAbilityIds;
	private Map<ModifierType, Integer> modifiers;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public List<String> getInnateAbilityIds() {
		return innateAbilityIds;
	}
	public void setInnateAbilityIds(List<String> innateAbilityIds) {
		this.innateAbilityIds = innateAbilityIds;
	}
	public List<String> getChosenAbilityIds() {
		return chosenAbilityIds;
	}
	public void setChosenAbilityIds(List<String> chosenAbilityIds) {
		this.chosenAbilityIds = chosenAbilityIds;
	}
	public Map<ModifierType, Integer> getModifiers() {
		return modifiers;
	}
	public void setModifiers(Map<ModifierType, Integer> modifiers) {
		this.modifiers = modifiers;
	}
	
	
}
