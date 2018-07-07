package org.outsiders.release.domain.request;

import org.outsiders.release.domain.Character;

public class CharacterRequest {

	private Character updated;
	private boolean cacheForRollback;
	
	public Character getUpdated() {
		return updated;
	}
	public void setUpdated(Character updated) {
		this.updated = updated;
	}
	public boolean isCacheForRollback() {
		return cacheForRollback;
	}
	public void setCacheForRollback(boolean cacheForRollback) {
		this.cacheForRollback = cacheForRollback;
	}
	
	
}
