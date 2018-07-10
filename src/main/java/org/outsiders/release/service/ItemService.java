package org.outsiders.release.service;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Item;

public interface ItemService {
	
	Item findByName(String name);
    
	Item insert(Item entity);

    List<Item> insert(Iterable<Item> entities);

	Optional<Item> findById(String id);

	boolean existsById(String id);

    List<Item> findAll();
    
	List<Item> findAllById(Iterable<String> ids);

	long count();

	void deleteById(String id);

	void delete(Item entity);

    void deleteAll(Iterable<? extends Item> entities);
    
	void deleteAll();
}