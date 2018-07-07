package org.outsiders.release.domain.request;

import org.outsiders.release.domain.Character;

public class CharacterRequest {

	private Character character;
	private boolean cacheForRollback;
	
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public boolean isCacheForRollback() {
		return cacheForRollback;
	}
	public void setCacheForRollback(boolean cacheForRollback) {
		this.cacheForRollback = cacheForRollback;
	}
	
	
}
