package org.outsiders.release.domain;

import java.util.List;

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
}