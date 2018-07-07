package org.outsiders.release.service;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Character;

public interface CharacterService {
    
	Character insert(Character entity);

    List<Character> insert(Iterable<Character> entities);

	Optional<Character> findById(String id);

	boolean existsById(String id);

    List<Character> findAll();
    
	List<Character> findAllById(Iterable<String> ids);

	long count();

	void deleteById(String id);

	void delete(Character entity);

    void deleteAll(Iterable<? extends Character> entities);
    
	void deleteAll();
}