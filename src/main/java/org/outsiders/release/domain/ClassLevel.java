package org.outsiders.release.domain;

import java.util.List;
import java.util.UUID;

import org.outsiders.release.domain.constant.ClassType;
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
	private List<ModMap> modifiers;
	
	public ClassLevel() {
		String id = UUID.randomUUID().toString();
		this.id = id;
	}
	
	public void updateClassLevel(ClassLevel c) throws Exception {
		if(this.getId().equals(c.getId())) {
			if(c.getLevel() != 0) { 
				this.setLevel(c.getLevel());
			}
			if(c.getClassType() != null) {
				this.setClassType(c.getClassType());
			}
			if(c.getInnateAbilityIds() != null) {
				if (!c.getInnateAbilityIds().isEmpty()) {
					this.setInnateAbilityIds(c.getInnateAbilityIds());
				}	
			}
			if(c.getChosenAbilityIds() != null) {
				if (!c.getChosenAbilityIds().isEmpty()) {
					this.setChosenAbilityIds(c.getChosenAbilityIds());
				}
			}
			if(c.getModifiers() != null) {
				if (!c.getModifiers().isEmpty()) {
					this.setModifiers(c.getModifiers());
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
	public List<ModMap> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<ModMap> modifiers) {
		this.modifiers = modifiers;
	}
	
}
