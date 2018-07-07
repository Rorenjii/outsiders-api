package org.outsiders.release.service;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.User;

public interface UserService {
    
	User insert(User entity);

    List<User> insert(Iterable<User> entities);

	Optional<User> findById(String id);
	
	User findByEmail(String email);

	boolean existsById(String id);

    List<User> findAll();
    
	List<User> findAllById(Iterable<String> ids);

	long count();

	void deleteById(String id);

	void delete(User entity);

    void deleteAll(Iterable<? extends User> entities);
    
	void deleteAll();
}