package org.outsiders.release.service;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.ClassLevel;

public interface ClassLevelService {
    
	ClassLevel insert(ClassLevel entity);

    List<ClassLevel> insert(Iterable<ClassLevel> entities);

	Optional<ClassLevel> findById(String id);
	
	boolean existsById(String id);

    List<ClassLevel> findAll();
    
	List<ClassLevel> findAllById(Iterable<String> ids);

	long count();

	void deleteById(String id);

	void delete(ClassLevel entity);

    void deleteAll(Iterable<? extends ClassLevel> entities);
    
	void deleteAll();
}