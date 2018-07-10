package org.outsiders.release.service;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.constant.RaceType;

public interface RaceService {
	
	Race findByType(RaceType type);
    
	Race insert(Race entity);

    List<Race> insert(Iterable<Race> entities);

	Optional<Race> findById(String id);
	
	boolean existsById(String id);

    List<Race> findAll();
    
	List<Race> findAllById(Iterable<String> ids);

	long count();

	void deleteById(String id);

	void delete(Race entity);

    void deleteAll(Iterable<? extends Race> entities);
    
	void deleteAll();
}