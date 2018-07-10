package org.outsiders.release.service;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Ability;

public interface AbilityService {
    
	Ability insert(Ability entity);
	
	Ability findByName(String name);

    List<Ability> insert(Iterable<Ability> entities);

	Optional<Ability> findById(String id);

	boolean existsById(String id);

    List<Ability> findAll();
    
	List<Ability> findAllById(Iterable<String> ids);

	long count();

	void deleteById(String id);

	void delete(Ability entity);

    void deleteAll(Iterable<? extends Ability> entities);
    
	void deleteAll();
}