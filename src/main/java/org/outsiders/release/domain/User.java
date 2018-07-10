package org.outsiders.release.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {
	
    @PrimaryKey
    private String id;
    
    private String name;
    
    private String email;
    private transient String password;
    private List<String> characterIds;
    
    public User() {
		String id = UUID.randomUUID().toString();
		this.id = id;
    }
    
    public void updateUser(User u) throws Exception {
    	if(this.getId().equals(u.getId())) {
			if(u.getName() != null) { 
				this.setName(u.getName());
			}
			if(u.getPassword() != null) {
				if (!u.getPassword().isEmpty()) {
					this.setPassword(u.getPassword());
				}	
			}
			if(u.getCharacterIds() != null) {
				if (!u.getCharacterIds().isEmpty()) {
					this.setCharacterIds(u.getCharacterIds());
				}	
			}
			if(u.getEmail() != null) {
				if (!u.getEmail().isEmpty()) {
					this.setEmail(u.getEmail());
				}	
			}
		} else {
			throw new Exception("ID MISMATCH");
		}
    }

	public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;        
    }

    public String getId() {
        return this.id;
    }

	public List<String> getCharacterIds() {
		return characterIds;
	}

	public void setCharacterIds(List<String> characterIds) {
		this.characterIds = characterIds;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", characterIds=" + characterIds + "]";
	}
	
	
}